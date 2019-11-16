package com.example.glidecaching.view.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.glidecaching.R;
import com.example.glidecaching.model.Response;
import com.example.glidecaching.utils.DatabindingUtils;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private static final String TAG = "TAG_ImageAdapter";
    private List data = new ArrayList<Response>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
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

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }

        void bind(Response response) {

            Log.d(TAG, "bind(): url" + response.getDownloadUrl());
            Glide.with(itemView.getContext())
                .load(response.getDownloadUrl())
                    .into(imageView);

        }
    }


}
