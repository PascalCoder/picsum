package com.example.picsum.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.picsum.R;
import com.example.picsum.model.Picsum;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class PicsumDetailsActivity extends AppCompatActivity {

    public static final String IMAGE_URL = "https://picsum.photos/400/400?image=";

    @BindView(R.id.iv_author_img)
    ImageView image;
    @BindViews({R.id.tv_format, R.id.tv_width, R.id.tv_height, R.id.tv_filename,
                R.id.tv_author, R.id.tv_author_url, R.id.tv_post_url})
    List<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picsum_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Picsum picsum = intent.getParcelableExtra("picsum");

        Picasso.get().load(IMAGE_URL + picsum.getId()).into(image);
        textViews.get(0).setText(getString(R.string.format_tag) + picsum.getFormat());
        textViews.get(1).setText(getString(R.string.width_tag) + picsum.getWidth());
        textViews.get(2).setText(getString(R.string.height_tag) + picsum.getHeight());
        textViews.get(3).setText(getString(R.string.file_name_tag) + picsum.getFilename());
        textViews.get(4).setText(getString(R.string.author_tag) + picsum.getAuthor());
        textViews.get(5).setText(getString(R.string.author_url_tag) + picsum.getAuthor_url());
        textViews.get(6).setText(getString(R.string.post_url_tag) + picsum.getPost_url());
    }
}
