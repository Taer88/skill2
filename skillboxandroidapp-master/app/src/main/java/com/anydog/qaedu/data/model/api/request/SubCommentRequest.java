package com.anydog.qaedu.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCommentRequest {
    @Expose
    @SerializedName("userId")
    private String userId;
    @Expose
    @SerializedName("text")
    private String text;
    @Expose
    @SerializedName("userName")
    private String userName;

    public SubCommentRequest(String userId, String userName, String text) {
        this.userId = userId;
        this.text = text;
        this.userId = userName;
    }
}
