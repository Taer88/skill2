package com.anydog.qaedu.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileRequest {
    @Expose
    @SerializedName("profileId")
    private String profileId;

    public ProfileRequest(String productId) {
        this.profileId = productId;
    }
}
