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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getSupportFragmentManager().findFragmentByTag(TAG_DETAIL_FRAGMENT) == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.detail_activity_frgSpace,
                    DetailFragment.newInstance(null,0), TAG_DETAIL_FRAGMENT);
            //todo reemplazar null y 0 por el mangabook y la posicion del item recibido por el intent
        }
        //getIntent().getExtras();
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
