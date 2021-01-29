package com.anydog.qaedu.ui.main;

import android.text.TextUtils;

import androidx.databinding.ObservableField;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {
    private static final String TAG = "MainViewModel";
    private final ObservableField<String> appVersion = new ObservableField<>();
    private final ObservableField<String> userEmail = new ObservableField<>();
    private final ObservableField<String> userName = new ObservableField<>();
    private final ObservableField<String> userProfilePicUrl = new ObservableField<>();

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public ObservableField<String> getUserEmail() {
        return userEmail;
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public ObservableField<String> getUserProfilePicUrl() {
        return userProfilePicUrl;
    }

    public void logout() {
        setIsLoading(true);
        getNavigator().logout();
    }

    public void onNavMenuCreated() {
//        final String currentUserName = getDataManager().getCurrentUserName();
//        if (!TextUtils.isEmpty(currentUserName)) {
//            userName.set(currentUserName);
//        }
//
//        final String currentUserEmail = getDataManager().getCurrentUserEmail();
//        if (!TextUtils.isEmpty(currentUserEmail)) {
//            userEmail.set(currentUserEmail);
//        }
//
//        final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
//        if (!TextUtils.isEmpty(profilePicUrl)) {
//            userProfilePicUrl.set(profilePicUrl);
//        }
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }
}
