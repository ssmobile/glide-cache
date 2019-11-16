package com.example.glidecaching.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.glidecaching.R;

public class FullImageActivity extends AppCompatActivity {

    private static final String TAG = "TAG_FullImageActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        ImageView fullImageView = findViewById(R.id.fullImage);
        Bundle b = getIntent().getExtras();
        assert b != null;
        String url = b.getString("url");
        Log.d(TAG, "onCreate: url:" + url);

        Glide.with(this)
                .load(url)
                .onlyRetrieveFromCache(true)
                .into(fullImageView);
    }
}
