package com.example.picsum.view;

import com.example.picsum.model.Picsum;

import java.util.List;

public interface ViewContract {
    void addPicsum(List<Picsum> dataSet);
    void addPicsumDetails(Picsum dataSet);
    void onError(String errorMessage);
}
