package com.anydog.qaedu.data.model.api.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> {
    @Expose
    @SerializedName("result")
    private RestStatus result;
    @Expose
    @SerializedName("info")
    private T info;
    @Expose
    @SerializedName("code")
    private String code;

    public String getCode() {
        return code;
    }

    public T getInfo() {
        return info;
    }

    public RestStatus getResult() {
        return result;
    }


}

