package com.example.glidecaching.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.glidecaching.model.Response;
import com.example.glidecaching.model.datasource.remote.retrofit.RetrofitHelper;
import com.example.glidecaching.model.rxjava.ImageObserver;

public class MainViewModel extends ViewModel implements ImageObserver.Callback {

    private static final String TAG = "TAG_MainViewModel";

    public MainViewModel() {

    }

    public void getImageResponse() {
        Log.d(TAG, "getImageResponse()");
        RetrofitHelper.getImageResponse(2,100, this);
    }

    @Override
    public void onResponse(Object response) {
        Log.d(TAG, "Response: " + response.toString());
    }
}
