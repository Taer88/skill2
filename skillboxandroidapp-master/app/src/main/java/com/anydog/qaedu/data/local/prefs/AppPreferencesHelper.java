package com.anydog.qaedu.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.anydog.qaedu.di.PreferenceInfo;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREFS_USER_ID = "PREFS_PROFILE";
    private static final String PREFS_USER_NAME = "PREFS_PROFILE";
    private static final String PREFS_PROFILE_ID = "PREFS_PROFILE";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAccessToken() {

        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public String getProfileId() {
        return mPrefs.getString(PREFS_PROFILE_ID, null);
    }

    @Override
    public void setProfileId(String profileId) {
        mPrefs.edit().putString(PREFS_PROFILE_ID, profileId).apply();
    }

    @Override
    public String getUserId() {
        return mPrefs.getString(PREFS_USER_ID, null);
    }

    @Override
    public void setUserName(String userName) {
        mPrefs.edit().putString(PREFS_USER_NAME, userName).apply();
    }

    @Override
    public String getUserName() {
        return mPrefs.getString(PREFS_USER_NAME, null);
    }

    @Override
    public void setUserId(String userId) {
        mPrefs.edit().putString(PREFS_USER_ID, userId).apply();
    }
}
