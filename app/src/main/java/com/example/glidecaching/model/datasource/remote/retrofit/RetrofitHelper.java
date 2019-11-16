package com.example.glidecaching.model.datasource.remote.retrofit;

import com.example.glidecaching.model.Response;
import com.example.glidecaching.model.datasource.remote.retrofit.services.ImageService;
import com.example.glidecaching.model.rxjava.ImageObserver;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.glidecaching.model.rxjava.ImageObserver.Callback;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static com.example.glidecaching.model.datasource.remote.UrlConstants.BASE_URL;

public class RetrofitHelper {

    private static Retrofit retrofitInstance;

    private static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {

            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofitInstance;
    }

    private static ImageService getImageService() {
        return getRetrofitInstance().create(ImageService.class);
    }

    public static void getImageResponse(int pageCount, int limit, Callback callback) {
        getImageService()
                .getImages(pageCount, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ImageObserver(callback));
    }

}
