package com.anydog.qaedu.data.model.api.data;

import com.anydog.qaedu.utils.AppUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BucketItem {
    @Expose
    @SerializedName("_id")
    private String id;
    @Expose
    @SerializedName("price")
    private float price;
    @Expose
    @SerializedName("count")
    private int count;
    @Expose
    @SerializedName("productId")
    private String productId;
    @Expose
    @SerializedName("imageUri")
    private String imageUri;

    public String getImageUri() {
        return AppUtils.getFixedImageUrl(imageUri);
    }

    public String getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getProductId() {
        return productId;
    }
}
