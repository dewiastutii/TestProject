package com.example.rpl88.wallezz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    }
}
