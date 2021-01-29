package com.anydog.qaedu.data.remote;

import com.androidnetworking.interfaces.UploadProgressListener;
import com.anydog.qaedu.data.local.prefs.PreferencesHelper;
import com.anydog.qaedu.data.model.api.request.BucketAddRequest;
import com.anydog.qaedu.data.model.api.request.CommentRequest;
import com.anydog.qaedu.data.model.api.request.EmailLoginRequest;
import com.anydog.qaedu.data.model.api.request.GoogleLoginRequest;
import com.anydog.qaedu.data.model.api.request.SubCommentRequest;
import com.anydog.qaedu.data.model.api.response.BucketAddResponse;
import com.anydog.qaedu.data.model.api.response.CommentAddResponse;
import com.anydog.qaedu.data.model.api.response.CommentsResponse;
import com.anydog.qaedu.data.model.api.response.LoginResponse;
import com.anydog.qaedu.data.model.api.response.ProductResponse;
import com.anydog.qaedu.data.model.api.response.ProductsResponse;
import com.anydog.qaedu.data.model.api.response.ProfileResponse;
import com.anydog.qaedu.data.model.api.response.SubCommentsResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    private PreferencesHelper prefs;
    private ApiHeader api;

    @Inject
    public AppApiHelper(ApiHeader apiHeader, PreferencesHelper prefManager) {
        prefs = prefManager;
        api = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return api;
    }

    @Override
    public Single<LoginResponse> googleLogin(GoogleLoginRequest request) {
        return post(EndPoint.REST_LOGIN, LoginResponse.class, request);
    }

    @Override
    public Single<LoginResponse> loginRequest(EmailLoginRequest request) {
        return post(EndPoint.REST_LOGIN, LoginResponse.class, request);
    }

    @Override
    public Single<LoginResponse> registerRequest(EmailLoginRequest request) {
        return post(EndPoint.REST_REGISTER, LoginResponse.class, request);
    }

    @Override
    public Single<ProductResponse> getProduct(String productId) {
        return get(EndPoint.REST_PRODUCTS + "/" + productId, ProductResponse.class);
    }

    @Override
    public Single<ProductsResponse> getProducts(boolean actions) {
        if (actions) {
            return get(EndPoint.REST_ACTION_PRODUCTS, ProductsResponse.class);
        } else {
            return get(EndPoint.REST_PRODUCTS, ProductsResponse.class);
        }

    }

    private String getProfileBucketEndpoint() {
        return EndPoint.REST_PROFILE + "/" + prefs.getProfileId() + "/bucket";
    }

    @Override
    public Single<BucketAddResponse> addToCart(String productId) {
        return patch(getProfileBucketEndpoint(), BucketAddResponse.class, new BucketAddRequest(productId));
    }

    @Override
    public Single<BucketAddResponse> removeFromCart(String itemId) {
        return delete(getProfileBucketEndpoint() + "/" + itemId, BucketAddResponse.class);
    }

    @Override
    public Single<ProfileResponse> getProfile(String profileId) {
        return get(EndPoint.REST_PROFILE + "/" + profileId, ProfileResponse.class);
    }

    @Override
    public Single<ProfileResponse> updateProfileImage(File file, String profileId, UploadProgressListener uploadListener) {
        return upload(EndPoint.REST_PROFILE + "/" + profileId, ProfileResponse.class, file, uploadListener);
    }

    @Override
    public Single<CommentsResponse> getComments(String productId) {
        return get(EndPoint.REST_PRODUCTS + "/" + productId + "/comments", CommentsResponse.class);
    }

    public Single<SubCommentsResponse> sendReply(String commentId, String text) {
        SubCommentRequest req = new SubCommentRequest(prefs.getUserId(), prefs.getUserName(), text);
        return patch(EndPoint.REST_COMMENTS + "/" + commentId + "/answer", SubCommentsResponse.class, req);
    }

    @Override
    public Single<CommentAddResponse> sendComment(String productId, String text) {
        CommentRequest req = new CommentRequest(productId, prefs.getUserId(), prefs.getUserName(), text);
        return put(EndPoint.REST_COMMENTS, CommentAddResponse.class, req);
    }


    ///------------------------------------------------
    @Override
    // TODO: SHIT
    public Single<String> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(EndPoint.ENDPOINT_LOGOUT)
                .addHeaders("X-Session-Id", prefs.getAccessToken())
                .build()
                .getObjectSingle(String.class);
    }

    public <T, TR> Single<T> post(String endpoint, Class<T> objectClass, TR request) {
        return Rx2AndroidNetworking.post(endpoint)
                .addHeaders(api.getProtectedApiHeader())
                .addApplicationJsonBody(request)
                .setContentType("application/json")
                .build()
                .getObjectSingle(objectClass);
    }

    public <T, TR> Single<T> put(String endpoint, Class<T> objectClass, TR request) {
        return Rx2AndroidNetworking.put(endpoint)
                .addHeaders(api.getProtectedApiHeader())
                .addApplicationJsonBody(request)
                .setContentType("application/json")
                .build()
                .getObjectSingle(objectClass);
    }

    public <T, TR> Single<T> patch(String endpoint, Class<T> objectClass, TR request) {
        return Rx2AndroidNetworking.patch(endpoint)
                .addHeaders(api.getProtectedApiHeader())
                .addApplicationJsonBody(request)
                .setContentType("application/json")
                .build()
                .getObjectSingle(objectClass);
    }

    public <T> Single<T> upload(String endpoint, Class<T> objectClass, File file, UploadProgressListener progressListener) {
        return Rx2AndroidNetworking.upload(endpoint)
                .addMultipartFile("avatar", file)
                .addHeaders(api.getProtectedApiHeader())
                .build()
                .setUploadProgressListener(progressListener)
                .getObjectSingle(objectClass);
    }

    public <T> Single<T> delete(String endpoint, Class<T> objectClass) {
        return Rx2AndroidNetworking.delete(endpoint)
                .addHeaders(api.getProtectedApiHeader())
                .build()
                .getObjectSingle(objectClass);
    }

    public <T> Single<T> get(String endpoint, Class<T> objectClass) {
        return Rx2AndroidNetworking.get(endpoint)
                .addHeaders(api.getProtectedApiHeader())
                .build()
                .getObjectSingle(objectClass);
    }
}
