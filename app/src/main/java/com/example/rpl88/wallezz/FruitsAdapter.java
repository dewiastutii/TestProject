package com.example.rpl88.wallezz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by rpl88 on 11/04/18.
 */

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.ViewHolder> {
    Fruits buah;

    public FruitsAdapter(Fruits buah) {
        this.buah = buah;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titelnya.setText(buah.getData().get(position).getTitle());
        holder.deskripsinya.setText(buah.getData().get(position).getDescription());
        holder.createnya.setText(buah.getData().get(position).getCreated_at());
        holder.updatenya.setText(buah.getData().get(position).getUpdated_at());
        Picasso.get().load(buah.getData().get(position).getImage()).into(holder.imagenya);

    }

    @Override
    public int getItemCount() {
        return buah.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titelnya, deskripsinya, createnya,updatenya;
        ImageView imagenya;

        public ViewHolder(View itemView) {
            super(itemView);
            titelnya=(TextView)itemView.findViewById(R.id.txt_title);
            deskripsinya=(TextView)itemView.findViewById(R.id.txt_description);
            createnya=(TextView)itemView.findViewById(R.id.txt_create);
            updatenya=(TextView)itemView.findViewById(R.id.txt_update);
            imagenya=(ImageView)itemView.findViewById(R.id.img);
        }
    }
}
