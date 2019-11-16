package com.example.glidecaching.model.datasource.remote.retrofit.services;

import android.database.Observable;

import com.example.glidecaching.model.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.glidecaching.model.datasource.remote.UrlConstants.LIMIT;
import static com.example.glidecaching.model.datasource.remote.UrlConstants.PAGE_COUNT;

public interface ImageService {

    @GET()
    Observable<Response> getImages(
        @Query(PAGE_COUNT) int pageCount,
        @Query(LIMIT) int limit
    );
}
