package com.anydog.qaedu.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.anydog.qaedu.BuildConfig;
import com.anydog.qaedu.R;
import com.anydog.qaedu.data.AppDataManager;
import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.data.local.db.AppDatabase;
import com.anydog.qaedu.data.local.db.AppDbHelper;
import com.anydog.qaedu.data.local.db.DbHelper;
import com.anydog.qaedu.data.local.prefs.AppPreferencesHelper;
import com.anydog.qaedu.data.local.prefs.PreferencesHelper;
import com.anydog.qaedu.data.remote.ApiHeader;
import com.anydog.qaedu.data.remote.ApiHelper;
import com.anydog.qaedu.data.remote.AppApiHelper;
import com.anydog.qaedu.di.ApiInfo;
import com.anydog.qaedu.di.DatabaseInfo;
import com.anydog.qaedu.di.PreferenceInfo;
import com.anydog.qaedu.utils.AppConstants;
import com.anydog.qaedu.utils.rx.AppSchedulerProvider;
import com.anydog.qaedu.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
