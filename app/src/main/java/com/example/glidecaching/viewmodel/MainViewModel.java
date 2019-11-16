package com.example.glidecaching.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.glidecaching.model.Response;
import com.example.glidecaching.model.datasource.remote.retrofit.RetrofitHelper;
import com.example.glidecaching.model.rxjava.ImageObserver;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel implements ImageObserver.Callback {

    private static final String TAG = "TAG_MainViewModel";
    public List<String> responses = new ArrayList<>();

    public MainViewModel() {

        getImageResponse();
    }

    private void getImageResponse() {
        Log.d(TAG, "getImageResponse()");
        RetrofitHelper.getImageResponse(2,100, this);
    }

    public void setData() {
        Log.d(TAG, "setData()");

    }


    @Override
    public void onResponse(List<Response> response) {
        Log.d(TAG, "Response: " + response.toString());

    }
}
