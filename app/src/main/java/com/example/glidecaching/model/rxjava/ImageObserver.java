package com.example.glidecaching.model.rxjava;

import android.telecom.Call;
import android.util.Log;

import com.example.glidecaching.model.Response;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class ImageObserver implements Observer<Object> {

    private Callback callback;
    private Object response;

    private static final String TAG = "TAG_ImageObserver";

    public ImageObserver(Callback callback) { this.callback = callback; }


    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");

    }

    @Override
    public void onNext(Object response) {
        Log.d(TAG, "onNext: ");
        this.response = response;

    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: ", e);

    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
        callback.onResponse(response);

    }

    public interface Callback {
        void onResponse(Object response);
    }
}
