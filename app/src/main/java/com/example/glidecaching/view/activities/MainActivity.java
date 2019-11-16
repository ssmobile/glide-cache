package com.example.glidecaching.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.media.Image;
import android.os.Bundle;
import android.util.Log;

import com.example.glidecaching.R;
import com.example.glidecaching.databinding.ActivityMainBinding;
import com.example.glidecaching.model.Response;
import com.example.glidecaching.model.rxjava.ImageObserver;
import com.example.glidecaching.view.adapters.ImageAdapter;
import com.example.glidecaching.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ImageObserver.Callback {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setViewModel(new MainViewModel(this));
    }

    private void initRecyclerView(List<Response> responses) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ImageAdapter adapter = new ImageAdapter();
        adapter.setData(responses);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResponse(List<Response> response) {
        initRecyclerView(response);

        Log.d(TAG, "Response: " + response.toString());

    }
}