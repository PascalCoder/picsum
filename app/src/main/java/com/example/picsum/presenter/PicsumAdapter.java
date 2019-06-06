package com.example.picsum.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.picsum.view.PicsumDetailsActivity;
import com.example.picsum.R;
import com.example.picsum.model.Picsum;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PicsumAdapter extends RecyclerView.Adapter<PicsumAdapter.PicsumViewHolder> {

    private List<Picsum> dataSet;
    public static final String IMAGE_URL = "https://picsum.photos/400/300?image=";
    private Context context;

    public PicsumAdapter(List<Picsum> dataSet){
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public PicsumAdapter.PicsumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new PicsumViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PicsumAdapter.PicsumViewHolder picsumViewHolder, int i) {
        String id = dataSet.get(i).getId();
        Picasso.get().load(IMAGE_URL + id).into(picsumViewHolder.image);
        picsumViewHolder.tvAuthor.setText(dataSet.get(i).getAuthor());

        picsumViewHolder.cardView.setOnClickListener(v -> {

            Log.d("PicsumAdapter: ", "onBindViewHolder: " + i);

            Intent intent = new Intent(context, PicsumDetailsActivity.class);
            intent.putExtra("picsum", dataSet.get(i));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

    class PicsumViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView tvAuthor;
        CardView cardView;

        public PicsumViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.iv_img);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
