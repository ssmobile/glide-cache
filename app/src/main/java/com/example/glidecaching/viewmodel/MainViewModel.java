package com.example.glidecaching.viewmodel;

import android.telecom.Call;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.glidecaching.model.Response;
import com.example.glidecaching.model.datasource.remote.retrofit.RetrofitHelper;
import com.example.glidecaching.model.rxjava.ImageObserver;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private static final String TAG = "TAG_MainViewModel";
    public MutableLiveData<List<Response>> responses = new MutableLiveData<>();
    private ImageObserver.Callback callback;

    public MainViewModel(ImageObserver.Callback callback) {
        this.callback = callback;
        getImageResponse();
    }

    private void getImageResponse() {
        Log.d(TAG, "getImageResponse()");
        RetrofitHelper.getImageResponse(2,100, callback);
    }


}
