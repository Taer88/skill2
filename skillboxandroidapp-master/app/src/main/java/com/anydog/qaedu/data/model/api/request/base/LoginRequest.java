package com.anydog.qaedu.data.model.api.request.base;

import com.anydog.qaedu.data.model.api.data.LoginType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class LoginRequest<T> {
    @Expose
    @SerializedName("type")
    private LoginType type;
    @Expose
    @SerializedName("creds")
    private T creds;
    @SerializedName("deviceId")
    private String deviceId;

    protected LoginRequest(LoginType type, String deviceId, T creds) {
        this.deviceId = deviceId;
        this.type = type;
        this.creds = creds;
    }
}






