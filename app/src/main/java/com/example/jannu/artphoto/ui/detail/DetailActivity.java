package com.example.jannu.artphoto.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.ui.main.MainActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    //intent
    public static void start(MainActivity mainActivity, String item, int position) {
    }
}
