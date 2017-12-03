package com.example.jannu.artphoto.ui.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.base.model.DataFiller;
import com.example.jannu.artphoto.base.model.MangaBook;
import com.example.jannu.artphoto.ui.detail.DetailActivity;
import com.example.jannu.artphoto.ui.detail.DetailFragment;
import com.example.jannu.artphoto.ui.manga.MangaFragment;
import com.example.jannu.artphoto.utils.ConfigurationUtils;
import com.example.jannu.artphoto.utils.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MangaFragment.Callback {

    @BindView(R.id.fragment_manga_imgMangaPreview)
    ImageView imgMangaPreview;
    private static final String TAG_MAIN_FRAGMENT = "TAG_MAIN_FRAGMENT";
    private static final String TAG_DETAIL_FRAGMENT = "TAG_DETAIL_FRAGMENT";
    private MangaBook selectedBook;
    private int selectedPosition;
    private MainActivityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT) == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.main_activity_frgSpace,
                    MangaFragment.newInstance(), TAG_MAIN_FRAGMENT);
        }
        if (ConfigurationUtils.hasLandscapeOrientation(this)
                && getSupportFragmentManager().findFragmentByTag(TAG_DETAIL_FRAGMENT) == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.main_activity_frgSpaceRight,
                    DetailFragment.newInstance(null,-1), TAG_DETAIL_FRAGMENT);
        }
        if (ConfigurationUtils.hasLandscapeOrientation(this)) {
            if(getSupportFragmentManager().findFragmentByTag(TAG_MAIN_FRAGMENT) == null){

            }else{

            }

        }

    }


    @Override
    public void onItemSelected(MangaBook item, int position) {
        if (ConfigurationUtils.hasLandscapeOrientation(this)) {
            showDetailFragment(item, position);
            selectedBook = item;
            selectedPosition = position;
        } else {
            selectedBook = item;
            selectedPosition = position;
            DetailActivity.start(this, item, position);
        }
    }
    //change the current image
    private void changeImage(ImageView img, int imageResId) {
        img.setImageResource(imageResId);
    }

    private void showDetailFragment(MangaBook item, int position) {
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
