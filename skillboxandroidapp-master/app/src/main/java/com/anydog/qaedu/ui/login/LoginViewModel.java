package com.anydog.qaedu.ui.login;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.data.model.api.request.EmailLoginRequest;
import com.anydog.qaedu.data.model.api.request.GoogleLoginRequest;
import com.anydog.qaedu.data.model.api.response.LoginResponse;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.AppUtils;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    private static final String TAG = "GoogleSignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private final ObservableField<Boolean> loginMode = new ObservableField<>();


    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        loginMode.set(true);
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
//        // validate email and password
//        if (TextUtils.isEmpty(email)) {
//            return false;
//        }
//        if (!CommonUtils.isEmailValid(email)) {
//            return false;
//        }
//        if (TextUtils.isEmpty(password)) {
//            return false;
//        }
        return true;
    }

    public void emailLogin(String email, String password, String deviceId) {
        setIsLoading(true);
        Observe(getDataManager().loginRequest(new EmailLoginRequest(email, password, deviceId)), this::UpdateAuthData);
    }

    public void sendGoogleAuth() {
        setIsLoading(true);
        getNavigator().googleSign();
    }

    public void googleLogin(String idToken, String deviceId, String email, String username, String avatar) {
        Observe(getDataManager().googleLogin(new GoogleLoginRequest(idToken, deviceId, email, username, avatar)), this::UpdateAuthData);
    }

    private void UpdateAuthData(LoginResponse response) {
        Log.d("LoginViewModel", response.getInfo().getUserId() + " - " + response.getInfo().getProfileId());
        getDataManager().setAccessToken(response.getInfo().getToken());
        getDataManager().setUserId(response.getInfo().getUserId());
        getDataManager().setProfileId(response.getInfo().getProfileId());
        getNavigator().openMainActivity();
    }

    public void onLoginClick() {
        getNavigator().emailLogin();
    }

    public ObservableField<Boolean> getLoginMode() {
        return loginMode;
    }

    public void changeMode(boolean login) {
        loginMode.set(!loginMode.get());
    }

    private void Registered(LoginResponse response) {

    }

    public void onRegiserClick() {
        getNavigator().emailRegister();
    }

    public void emailRegister(String email, String password, String deviceId) {
        if (email.contains("|") || email.contains("\"")
                || email.contains("?") || email.contains("^")
                || email.contains("\uD83D\uDE18")
                || email.contains("\uD83D\uDE04")
                || email.contains("☺")
                || email.contains("\uD83D\uDE0A")
                || email.contains(":)")
        ) {
            AppUtils.crash();
        }
        Observe(getDataManager().registerRequest(new EmailLoginRequest(email, password, deviceId)), this::Registered);
    }

}
