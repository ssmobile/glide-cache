package com.example.glidecaching.model.datasource.remote.retrofit.services;

import com.example.glidecaching.model.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.glidecaching.model.datasource.remote.UrlConstants.LIMIT;
import static com.example.glidecaching.model.datasource.remote.UrlConstants.PAGE_COUNT;

public interface ImageService {

    @GET("list")
    Observable<List<Response>> getImages(
        @Query(PAGE_COUNT) int pageCount,
        @Query(LIMIT) int limit
    );
}
