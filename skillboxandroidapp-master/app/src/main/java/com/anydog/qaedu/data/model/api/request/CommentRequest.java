package com.anydog.qaedu.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentRequest {
    @Expose
    @SerializedName("userId")
    private String userId;
    @Expose
    @SerializedName("text")
    private String text;
    @Expose
    @SerializedName("userName")
    private String userName;
    @Expose
    @SerializedName("productId")
    private String productId;

    public CommentRequest(String productId,String userId, String userName, String text) {
        this.productId = productId;
        this.userId = userId;
        this.text = text;
        this.userId = userName;
    }
}
