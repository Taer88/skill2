package com.anydog.qaedu.data.model.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCommentItem {
    @Expose
    @SerializedName("_id")
    private String id;
    @Expose
    @SerializedName("userId")
    private String userId;
    @Expose
    @SerializedName("text")
    private String text;
    @Expose
    @SerializedName("userName")
    private String userName;
    public String getId() {
        return id;
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
}
