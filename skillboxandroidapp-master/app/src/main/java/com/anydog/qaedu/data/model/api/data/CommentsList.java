package com.anydog.qaedu.data.model.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommentsList {
    @Expose
    @SerializedName("comments")
    List<CommentItem> comments;
    @Expose
    @SerializedName("count")
    int count;

    public int getCount() {
        return count;
    }

    public List<CommentItem> getComments() {
        return comments;
    }
}
