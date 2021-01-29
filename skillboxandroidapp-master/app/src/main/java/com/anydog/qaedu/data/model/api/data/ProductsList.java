package com.anydog.qaedu.data.model.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsList {
    @Expose
    @SerializedName("products")
    List<Product> products;
    @Expose
    @SerializedName("count")
    int count;

    public int getCount() {
        return count;
    }

    public List<Product> getProducts() {
        return products;
    }
}
