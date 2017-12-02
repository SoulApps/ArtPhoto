package com.example.jannu.artphoto.ui.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.ui.main.MainActivity;

public class DetailActivity extends AppCompatActivity {
    private static final String EXTRA_POSITION = "EXTRA_POSITION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    //intent
    public static void start(AppCompatActivity activity, String item, int position) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_POSITION, position);
        activity.startActivity(intent);
    }
}
