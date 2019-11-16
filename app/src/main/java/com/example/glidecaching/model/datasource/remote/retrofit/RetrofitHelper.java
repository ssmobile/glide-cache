package com.example.glidecaching.model.datasource.remote.retrofit;

import com.example.glidecaching.model.datasource.remote.retrofit.services.ImageService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.glidecaching.model.datasource.remote.UrlConstants.BASE_URL;

public class RetrofitHelper {

    private static Retrofit retrofitInstance;

    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofitInstance;
    }

    public ImageService getImageService() {
        return retrofitInstance.create(ImageService.class);

    }
}
