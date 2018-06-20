package com.muzima.view.setupconfiguration.utils;

import android.content.SharedPreferences;
import android.graphics.Bitmap;

public class ImageSharedPreferences {

    public static void saveImageLogo(Bitmap bitmap, SharedPreferences sharedPreferences){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("imagePreferance", ImageUtils.encodeTobase64(bitmap));
        editor.apply();
    }
}
