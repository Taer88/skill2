package com.anydog.qaedu.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductRequest {
    @Expose
    @SerializedName("productId")
    private String productId;

    public ProductRequest(String productId) {
        this.productId = productId;
    }
}
