package com.anydog.qaedu.data.remote;

import com.anydog.qaedu.di.ApiInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHeader {

    private ProtectedApiHeader protectedApiHeader;

    private PublicApiHeader publicApiHeader;

    @Inject
    public ApiHeader(PublicApiHeader publicApiHeader, ProtectedApiHeader protectedApiHeader) {
        this.publicApiHeader = publicApiHeader;
        this.protectedApiHeader = protectedApiHeader;
    }

    public ProtectedApiHeader getProtectedApiHeader() {
        return protectedApiHeader;
    }

    public PublicApiHeader getPublicApiHeader() {
        return publicApiHeader;
    }

    public static final class ProtectedApiHeader {

        @Expose
        @SerializedName("authorization")
        private String accessToken;

        @Expose
        @SerializedName("api_key")
        private String apiKey;

        @Expose
        @SerializedName("user_id")
        private String userId;

        public ProtectedApiHeader(String mApiKey, String mUserId, String mAccessToken) {
            this.apiKey = mApiKey;
            this.userId = mUserId;
            this.accessToken = mAccessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setUserId(String mUserId) {
            this.userId = mUserId;
        }
    }

    public static final class PublicApiHeader {

        @Expose
        @SerializedName("api_key")
        private String mApiKey;

        @Inject
        public PublicApiHeader(@ApiInfo String apiKey) {
            mApiKey = apiKey;
        }
    }
}
