package com.anydog.qaedu.data.local.prefs;

public interface PreferencesHelper {

    void setAccessToken(String accessToken);
    String getAccessToken();

    void setProfileId(String profileId);
    String getProfileId();

    void setUserId(String userId);
    String getUserId();

    void setUserName(String userName);
    String getUserName();
}
