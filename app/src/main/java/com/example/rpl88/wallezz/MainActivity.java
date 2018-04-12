package com.example.rpl88.wallezz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ApiInterface apiInterface;
    private FruitsAdapter adapter;
    private ApiClient apiClient;
    private Fruits buahnya;
    private Biodata biodata;
    private EditText namanya, alamatnya;
    private Button simpan;
    String nama,alamat;
    private static final String API_KEY="JDJ5JDEwJExUdVZzS0hFRjBDeFF4dWltV3hCUi4xeGpRWm4uUkYuaHczcS9zOVVtQTFqcEtWZjR2Z24u";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv_list);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<Fruits> call=apiInterface.getFruits(API_KEY);
        call.enqueue(new Callback<Fruits>() {
            @Override
            public void onResponse(Call<Fruits> call, Response<Fruits> response) {
                buahnya=response.body();
                adapter=new FruitsAdapter(buahnya);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Fruits> call, Throwable t) {

            }
        });

        namanya=(EditText)findViewById(R.id.edtname);
        alamatnya=(EditText)findViewById(R.id.edtadress);
        simpan=(Button)findViewById(R.id.btn_simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama=namanya.getText().toString().trim();
                alamat=alamatnya.getText().toString().trim();
                apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
                biodata = new Biodata(nama,alamat);
                Call<Biodata> call=apiInterface.saveBiodata(biodata,API_KEY);
                call.enqueue(new Callback<Biodata>() {
                    @Override
                    public void onResponse(Call<Biodata> call, Response<Biodata> response) {
                        Toast.makeText(MainActivity.this,"Berhasil",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Biodata> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Gagal",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });



    }
}



