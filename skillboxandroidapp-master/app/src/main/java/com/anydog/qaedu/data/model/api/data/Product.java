package com.anydog.qaedu.data.model.api.data;

import com.anydog.qaedu.utils.AppUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @Expose
    @SerializedName("_id")
    private String id;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("price")
    private float price;
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("size")
    private Size size;
    @Expose
    @SerializedName("info")
    private String info;
    @Expose
    @SerializedName("productImage")
    private String productImage;
    @Expose
    @SerializedName("performance")
    private boolean performance;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public Size getSize() {
        return size;
    }

    public String getInfo() {
        return info;
    }

    public String getProductImage() {
        return AppUtils.getFixedImageUrl(productImage);
    }

    public boolean getPerformance() {
        return performance;
    }

    public String getId() {
        return id;
    }
}
