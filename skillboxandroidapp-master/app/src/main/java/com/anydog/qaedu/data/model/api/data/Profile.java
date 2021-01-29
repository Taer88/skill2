package com.anydog.qaedu.data.model.api.data;

import com.anydog.qaedu.utils.AppUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Profile {
    @Expose
    @SerializedName("_id")
    String id;
    @Expose
    @SerializedName("avatar")
    String avatar;
    @Expose
    @SerializedName("username")
    String username;
    @Expose
    @SerializedName("about")
    String about;
    @Expose
    @SerializedName("bucket")
    List<BucketItem> bucket;

    public String getId() {
        return id;
    }

    public String getAvatar() {
        return AppUtils.getFixedImageUrl(avatar);
    }

    public String getUsername() {
        return username;
    }

    public String getAbout() {
        return about;
    }

    public List<BucketItem> getBucket() {
        return bucket;
    }
}
