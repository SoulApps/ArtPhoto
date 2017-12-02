package com.example.jannu.artphoto.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by jannu on 12/2/17.
 */

public class ConfigurationUtils {

    private ConfigurationUtils() {
    }

    public static boolean hasLandscapeOrientation(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

}
