package com.example.picsum.presenter;

import com.example.picsum.view.ViewContract;

public interface PresenterContract {

    void bindView(ViewContract view);
    void initializeRetrofit();
    void getPicsums();
    void getPicsumsDetails(String id);
    void onDestroy();
}
