package com.example.jannu.artphoto.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.base.model.MangaBook;
import com.example.jannu.artphoto.ui.main.MainActivity;

public class DetailActivity extends AppCompatActivity {
    private static final String EXTRA_POSITION = "EXTRA_POSITION";
    private static final String EXTRA_ITEM = "EXTRA_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    //intent
    public static void start(Activity activity, MangaBook item, int position) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(EXTRA_POSITION, position);
        intent.putExtra(EXTRA_ITEM, item);
        activity.startActivity(intent);
    }
}
