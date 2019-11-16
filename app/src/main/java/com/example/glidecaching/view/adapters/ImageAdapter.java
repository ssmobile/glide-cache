package com.example.glidecaching.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.glidecaching.R;
import com.example.glidecaching.model.Response;
import com.example.glidecaching.utils.DatabindingUtils;
import com.example.glidecaching.view.activities.FullImageActivity;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private static final String TAG = "TAG_ImageAdapter";
    private List data = new ArrayList<Response>();
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        this.context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new ViewHolder(layoutInflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.bind((Response) data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Response> data) {
        this.data = data;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        Response response;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,FullImageActivity.class);
                    Bundle b= new Bundle();
                    b.putString("url", response.getDownloadUrl());
                    intent.putExtras(b);
                    itemView.getContext().startActivity(intent);
                }
            });
        }


        void bind(Response response) {
            this.response = response;

            Log.d(TAG, "bind(): url" + response.getDownloadUrl());
            Glide.with(itemView.getContext())
                .load(this.response.getDownloadUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        }
    }


}
