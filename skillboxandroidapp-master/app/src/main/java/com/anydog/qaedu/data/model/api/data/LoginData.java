package com.anydog.qaedu.data.model.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {
    @Expose
    @SerializedName("token")
    private String token;

    @SerializedName("userId")
    private String userId;

    @SerializedName("profileId")
    private String profileId;

    public String getToken() {
        return token;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getUserId() {
        return userId;
    }
}
