package com.example.jannu.artphoto.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.base.model.MangaBook;
import com.example.jannu.artphoto.ui.main.MainActivity;
import com.example.jannu.artphoto.ui.manga.MangaFragment;
import com.example.jannu.artphoto.utils.FragmentUtils;

public class DetailActivity extends AppCompatActivity implements DetailFragment.Callback{
    private static final String EXTRA_POSITION = "EXTRA_POSITION";
    private static final String EXTRA_ITEM = "EXTRA_ITEM";
    private static final String TAG_DETAIL_FRAGMENT = "TAG_DETAIL_FRAGMENT";
    private MangaBook manga;
    private int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        obtainProfileData();
        attachDetailFragment(manga,currentPos);
    }

    private void obtainProfileData() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(intent.hasExtra(EXTRA_POSITION)){
            currentPos = extras.getInt(EXTRA_POSITION);
            manga = extras.getParcelable(EXTRA_ITEM);
        }
    }

    private void attachDetailFragment(MangaBook book, int position) {
        if (getSupportFragmentManager().findFragmentByTag(TAG_DETAIL_FRAGMENT) == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.detail_activity_frgSpace,
                    DetailFragment.newInstance(book,position), TAG_DETAIL_FRAGMENT);
        }
    }

    //intent
    public static void start(Activity activity, MangaBook item, int position) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(EXTRA_POSITION, position);
        intent.putExtra(EXTRA_ITEM, item);
        activity.startActivity(intent);
    }

    @Override
    public void onDetailShown(int position) {
        //todo rellenar
    }
}
