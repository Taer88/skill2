package com.anydog.qaedu.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.anydog.qaedu.R;
import com.anydog.qaedu.data.remote.EndPoint;

public final class AppUtils {

    private AppUtils() {
    }

    public static void openPlayStoreForApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_market_link) + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_google_play_store_link) + appPackageName)));
        }
    }

    public static String getFixedImageUrl(String url) {
        if (url == null || url == "") {
            url = EndPoint.RESOURCES_URL + "uploads/default.jpg";
        }
        if (!url.contains("http")) {
            url = (EndPoint.RESOURCES_URL + url);
        }
        return url.replace("\\", "/");
    }


    public static void crash() {
        emulateCrash(0);
    }

    private static void emulateCrash(int a) {
        int x = 6 / a;
    }
}
