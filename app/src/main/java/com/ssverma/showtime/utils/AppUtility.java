package com.ssverma.showtime.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class AppUtility {

    private AppUtility() {
        //Prevent instantiation
    }

    public static String buildThumbnailUrl(String videoId) {
        return "http://img.youtube.com/vi/" + videoId + "/0.jpg";
    }

    public static void launchYoutube(Context context, String videoId) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube" + videoId));
        if (appIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(appIntent);
            return;
        }

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + videoId));
        if (browserIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(browserIntent);
            return;
        }

        ViewUtils.displayToast(context, "Unable to launch!");
    }

}