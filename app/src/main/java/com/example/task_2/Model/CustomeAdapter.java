package com.example.task_2.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task_2.MainActivity;
import com.example.task_2.R;

import java.util.List;


public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyHolder> {
    List<DataModel> dataModelDto;
    static Context context;

    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/w185";

    public CustomeAdapter(List<DataModel> moviesList) {
        this.dataModelDto = moviesList;
    }
    public void addItems(List<DataModel> borrowModelList) {
        this.dataModelDto = borrowModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_item, viewGroup, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        DataModel dataModel = dataModelDto.get(i);
        myHolder.title.setText(dataModel.getTitle());
        myHolder.rate.setText(dataModel.getVoteAverage());
        String imgUrl = dataModel.getPosterPath();
        Glide.with(context).load(IMAGE_URL + imgUrl)
                .into(myHolder.imageView);


    }

    @Override
    public int getItemCount() {
        return dataModelDto.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title, rate;
        ImageView imageView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = itemView.findViewById(R.id.title);
            rate = itemView.findViewById(R.id.rate);
            imageView = itemView.findViewById(R.id.poster_iv);
        }
    }
}