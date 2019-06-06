package com.example.picsum.model;

import com.example.picsum.model.Picsum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PicsumApi {

    @GET("list")
    Call<List<Picsum>> getPicsum();

    @GET("400/300/")
    Call<Picsum> getPicsumDetails(@Query("imageId")String id);
}
