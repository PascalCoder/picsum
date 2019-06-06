package com.example.picsum.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.picsum.R;
import com.example.picsum.model.Picsum;
import com.example.picsum.presenter.PicsumAdapter;
import com.example.picsum.presenter.Presenter;
import com.example.picsum.presenter.PresenterContract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  ViewContract{

    PresenterContract presenter;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        presenter = new Presenter();
        presenter.bindView(this);
        presenter.initializeRetrofit();
        presenter.getPicsums();
    }

    @Override
    public void addPicsum(List<Picsum> dataSet) {
        recyclerView.setAdapter(new PicsumAdapter(dataSet));
    }

    @Override
    public void addPicsumDetails(Picsum dataSet) {

    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}
