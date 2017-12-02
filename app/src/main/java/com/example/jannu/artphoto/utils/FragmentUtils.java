package com.example.jannu.artphoto.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.jannu.artphoto.base.model.MangaBook;

/**
 * Created by jannu on 12/2/17.
 */

public class FragmentUtils {

    private FragmentUtils() {
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                       @IdRes int parentResId, @NonNull Fragment fragment, @NonNull String tag) {
        fragmentManager.beginTransaction().replace(parentResId, fragment, tag).commit();
    }

    @SuppressWarnings("SameParameterValue")
    public static void replaceFragmentAddToBackstack(@NonNull FragmentManager fragmentManager,
                                                     @IdRes int parentResId, @NonNull Fragment fragment, @NonNull String tag,
                                                     @NonNull MangaBook backstackTag, int transition) {
        fragmentManager.beginTransaction().replace(parentResId, fragment, tag).setTransition(
                transition).addToBackStack(backstackTag.getTitle()).commit();
    }
}
