package com.example.glidecaching.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.glidecaching.R;
import com.example.glidecaching.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MainViewModel().getImageResponse();
    }
}
