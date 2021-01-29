package com.anydog.qaedu.data.remote;

import com.androidnetworking.interfaces.UploadProgressListener;
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

import java.io.File;

import io.reactivex.Single;

public interface ApiHelper {

    ApiHeader getApiHeader();

    // Login
    //// Google
    Single<LoginResponse> googleLogin(GoogleLoginRequest request);

    //// Email
    Single<LoginResponse> loginRequest(EmailLoginRequest request);
    Single<LoginResponse> registerRequest(EmailLoginRequest request);
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    // Products
    //// Get
    Single<ProductResponse> getProduct(String productId);

    //// Get all
    Single<ProductsResponse> getProducts(boolean actions);

    //// Bucket
    Single<BucketAddResponse> addToCart(String productId);

    Single<BucketAddResponse> removeFromCart(String productId);

    //----------------------------------------------------------------------------------------------
    // Profile
    Single<ProfileResponse> getProfile(String profileId);

    Single<ProfileResponse> updateProfileImage(File file, String profileId, UploadProgressListener uploadListener);

    //// Get comments
    Single<CommentsResponse> getComments(String productId);

    Single<SubCommentsResponse> sendReply(String commentId, String text);

    Single<CommentAddResponse> sendComment(String productId, String text);

    //----------------------------------------------------------------------------------------------
    // TODO: logout
    Single<String> doLogoutApiCall();


}
