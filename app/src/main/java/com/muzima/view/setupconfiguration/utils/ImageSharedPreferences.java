package com.muzima.view.setupconfiguration.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import com.muzima.view.setupconfiguration.constants.UserConfigConstants;

import static android.content.Context.MODE_PRIVATE;

public class ImageSharedPreferences {

    public static void saveImageLogo(Bitmap bitmap, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(UserConfigConstants.USER_PREF, MODE_PRIVATE).edit();
        editor.putString(UserConfigConstants.IMAGE_PATH, ImageUtils.encodeTobase64(bitmap));
        editor.apply();
        editor.commit();
    }
    public static Bitmap retrieveImageLogo(Context context){
        SharedPreferences prefs = context.getSharedPreferences(UserConfigConstants.USER_PREF, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        String image_path = "";
        if (restoredText != null) {
            image_path = prefs.getString(UserConfigConstants.IMAGE_PATH, "No image defined");
        }
        return ImageUtils.decodeBase64(image_path);
    }
    public static void saveTitle(String title, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(UserConfigConstants.USER_PREF, MODE_PRIVATE).edit();
        editor.putString(UserConfigConstants.FACILITY_NAME, title);
        editor.apply();
        editor.commit();
    }
    public static String retrieveTitle(Context context){
        SharedPreferences prefs = context.getSharedPreferences(UserConfigConstants.USER_PREF, MODE_PRIVATE);
       return prefs.getString(UserConfigConstants.FACILITY_NAME,"null");
    }
}
