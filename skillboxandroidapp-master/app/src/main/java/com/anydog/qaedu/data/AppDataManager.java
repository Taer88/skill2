package com.anydog.qaedu.data;

import android.content.Context;

import com.androidnetworking.interfaces.UploadProgressListener;
import com.anydog.qaedu.data.local.db.DbHelper;
import com.anydog.qaedu.data.local.prefs.PreferencesHelper;
import com.anydog.qaedu.data.model.api.data.Profile;
import com.anydog.qaedu.data.model.api.request.EmailLoginRequest;
import com.anydog.qaedu.data.model.api.request.GoogleLoginRequest;
import com.anydog.qaedu.data.model.api.response.BucketAddResponse;
import com.anydog.qaedu.data.model.api.response.CommentAddResponse;
import com.anydog.qaedu.data.model.api.response.CommentsResponse;
import com.anydog.qaedu.data.model.api.response.LoginResponse;
import com.anydog.qaedu.data.model.api.response.ProductResponse;
import com.anydog.qaedu.data.model.api.response.ProductsResponse;
import com.anydog.qaedu.data.model.api.response.ProfileResponse;
import com.anydog.qaedu.data.model.api.response.SubCommentsResponse;
import com.anydog.qaedu.data.model.db.User;
import com.anydog.qaedu.data.remote.ApiHeader;
import com.anydog.qaedu.data.remote.ApiHelper;
import com.google.gson.Gson;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final ApiHelper _api;
    private final Context _context;
    private final DbHelper _db;
    private final Gson _gson;
    private final PreferencesHelper _prefs;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        _context = context;
        _db = dbHelper;
        _prefs = preferencesHelper;
        _api = apiHelper;
        _gson = gson;
    }

    @Override
    public Single<LoginResponse> googleLogin(GoogleLoginRequest request) {
        return _api.googleLogin(request);
    }

    @Override
    public Single<String> doLogoutApiCall() {
        return _api.doLogoutApiCall();
    }

    @Override
    public Single<LoginResponse> loginRequest(EmailLoginRequest request) {
        return _api.loginRequest(request);
    }

    @Override
    public Single<LoginResponse> registerRequest(EmailLoginRequest request) {
        return _api.registerRequest(request);
    }

    @Override
    public Single<ProductResponse> getProduct(String productId) {
        return _api.getProduct(productId);
    }

    @Override
    public Single<ProductsResponse> getProducts(boolean actions) {
        return _api.getProducts(actions);
    }

    @Override
    public Single<BucketAddResponse> addToCart(String productId) {
        return _api.addToCart(productId);
    }

    @Override
    public Single<BucketAddResponse> removeFromCart(String productId) {
        return _api.removeFromCart(productId);
    }

    @Override
    public Single<ProfileResponse> getProfile(String profileId) {
        return _api.getProfile(profileId);
    }

    @Override
    public Single<ProfileResponse> updateProfileImage(File file, String profileId, UploadProgressListener uploadListener) {
        return _api.updateProfileImage(file, profileId, uploadListener);
    }

    @Override
    public Single<CommentsResponse> getComments(String productId) {
        return _api.getComments(productId);
    }

    @Override
    public Single<SubCommentsResponse> sendReply(String commentId, String text) {
        return _api.sendReply(commentId, text);
    }

    @Override
    public Single<CommentAddResponse> sendComment(String productId, String text) {
        return _api.sendComment(productId, text);
    }

    @Override
    public String getAccessToken() {
        return _prefs.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        _prefs.setAccessToken(accessToken);
        _api.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public String getProfileId() {
        return _prefs.getProfileId();
    }

    @Override
    public void setProfileId(String profileId) {
        _prefs.setProfileId(profileId);
    }

    @Override
    public String getUserId() {
        return _prefs.getUserId();
    }

    @Override
    public void setUserId(String userId) {
        _prefs.setUserId(userId);
    }

    @Override
    public String getUserName() {
        return _prefs.getUserName();
    }

    @Override
    public void setUserName(String userId) {
        _prefs.setUserName(userId);
    }

    @Override
    public Observable<List<com.anydog.qaedu.data.model.db.User>> getAllUsers() {
        return _db.getAllUsers();
    }

    @Override
    public ApiHeader getApiHeader() {
        return _api.getApiHeader();
    }


    @Override
    public Observable<Boolean> insertUser(com.anydog.qaedu.data.model.db.User user) {
        return _db.insertUser(user);
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    @Override
    public void updateApiHeader(String userId, String accessToken) {
        _api.getApiHeader().getProtectedApiHeader().setUserId(userId);
        _api.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(Profile profile, User user, String token) {

    }
}
