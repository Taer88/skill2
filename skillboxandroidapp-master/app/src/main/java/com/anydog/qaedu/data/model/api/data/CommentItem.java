package com.anydog.qaedu.data.model.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommentItem {
    @Expose
    @SerializedName("_id")
    private String id;
    @Expose
    @SerializedName("productId")
    private String productId;
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
    @SerializedName("subComments")
    List<SubCommentItem> subComments;

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public String getUserName() {
        return userName;
    }

    public List<SubCommentItem> getSubComments() {
        return subComments;
    }
}
