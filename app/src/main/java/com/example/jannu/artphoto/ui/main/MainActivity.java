package com.example.jannu.artphoto.ui.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.ui.detail.DetailActivity;
import com.example.jannu.artphoto.ui.detail.DetailFragment;
import com.example.jannu.artphoto.ui.manga.MangaFragment;
import com.example.jannu.artphoto.utils.ConfigurationUtils;
import com.example.jannu.artphoto.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity implements MangaFragment.Callback {

    private static final String TAG_MAIN_FRAGMENT = "TAG_MAIN_FRAGMENT";
    private static final String TAG_DETAIL_FRAGMENT = "TAG_DETAIL_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT) == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.main_activity_frgSpace,
                    MangaFragment.newInstance(), TAG_MAIN_FRAGMENT);
        }
        /*if (ConfigurationUtils.hasLandscapeOrientation(this)
                && getSupportFragmentManager().findFragmentByTag(TAG_DETAIL_FRAGMENT) == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.flDetail,
                    DetailFragment.newInstance(getString(R.string.main_activity_no_item),
                            MainFragment.NO_ITEM_SELECTED), TAG_MAIN_FRAGMENT);
        }*/
    }

    @Override
    public void onItemSelected(String item, int position) {
        if (ConfigurationUtils.hasLandscapeOrientation(this)) {
            showDetailFragment(item, position);
        } else {
            DetailActivity.start(this, item, position);
        }
    }

    private void showDetailFragment(String item, int position) {
        FragmentUtils.replaceFragmentAddToBackstack(getSupportFragmentManager(), R.id.detail_activity_frgSpace,
                DetailFragment.newInstance(item, position), TAG_DETAIL_FRAGMENT, item,
                FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
    }

    // When detail shown (even from backstack).
    @Override
    public void onDetailShown(int position) {
        MangaFragment mangaFragment = (MangaFragment) getSupportFragmentManager().findFragmentById(
                R.id.main_activity_frgSpace);
        mangaFragment.selectItem(position);
    }

    @Override
    public void onBackPressed() {
        if (!ConfigurationUtils.hasLandscapeOrientation(this)) {
            // No backstack.
            getSupportFragmentManager().popBackStack(null,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        super.onBackPressed();
    }
}
