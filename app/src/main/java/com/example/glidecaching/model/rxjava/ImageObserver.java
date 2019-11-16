package com.example.glidecaching.model.rxjava;

import android.util.Log;

import com.example.glidecaching.model.Response;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class ImageObserver implements Observer<List<Response>> {

    private Callback callback;
    private List<Response> responses;

    private static final String TAG = "TAG_ImageObserver";

    public ImageObserver(Callback callback) { this.callback = callback; }


    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG, "onSubscribe: ");

    }

    @Override
    public void onNext(List<Response> response) {
        Log.d(TAG, "onNext: ");
        this.responses = response;

    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: ", e);

    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
        callback.onResponse(responses);

    }

    public interface Callback {
        void onResponse(List<Response> response);
    }
}
