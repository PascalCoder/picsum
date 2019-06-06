package com.example.picsum.presenter;

import android.util.Log;

import com.example.picsum.model.Picsum;
import com.example.picsum.model.PicsumApi;
import com.example.picsum.view.ViewContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterContract {

    public static final String BASE_URL = "https://picsum.photos/";
    private PicsumApi api;
    ViewContract viewContract;

    @Override
    public void bindView(ViewContract view) {
        this.viewContract = view;
    }

    @Override
    public void initializeRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        api = retrofit.create(PicsumApi.class);
    }

    @Override
    public void getPicsums() {
        api.getPicsum().enqueue(new Callback<List<Picsum>>() {
            @Override
            public void onResponse(Call<List<Picsum>> call, Response<List<Picsum>> response) {
                viewContract.addPicsum(response.body());
            }

            @Override
            public void onFailure(Call<List<Picsum>> call, Throwable t) {
                Log.d("Presenter: ", "onFailure: Something went wrong!");
            }
        });
    }

    @Override
    public void getPicsumsDetails(String id) {
        api.getPicsumDetails(id).enqueue(new Callback<Picsum>() {
            @Override
            public void onResponse(Call<Picsum> call, Response<Picsum> response) {
                viewContract.addPicsumDetails(response.body());
            }

            @Override
            public void onFailure(Call<Picsum> call, Throwable t) {
                Log.d("Presenter: ", "onFailure: Something went wrong!");
            }
        });
    }

    @Override
    public void onDestroy() {

    }
}
