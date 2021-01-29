package com.anydog.qaedu;

import android.app.Activity;
import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.anydog.qaedu.di.component.DaggerAppComponent;
import com.anydog.qaedu.utils.AppLogger;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class QaEduApplication extends android.app.Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    private static Context context;

    public static Context getAppContext() {
        return QaEduApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        QaEduApplication.context = getApplicationContext();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BASIC);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }
}
