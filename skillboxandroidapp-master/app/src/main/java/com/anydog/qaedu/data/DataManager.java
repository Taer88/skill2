package com.anydog.qaedu.data;

import com.anydog.qaedu.data.local.db.DbHelper;
import com.anydog.qaedu.data.local.prefs.PreferencesHelper;
import com.anydog.qaedu.data.model.api.data.Profile;
import com.anydog.qaedu.data.model.db.User;
import com.anydog.qaedu.data.remote.ApiHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void setUserAsLoggedOut();

    void updateApiHeader(String userId, String accessToken);

    void updateUserInfo(Profile profile, User user, String token);

    enum LoggedInMode {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);
        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
