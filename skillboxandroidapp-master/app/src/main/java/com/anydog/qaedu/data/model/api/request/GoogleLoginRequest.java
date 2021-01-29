package com.anydog.qaedu.data.model.api.request;

import com.anydog.qaedu.data.model.api.data.LoginType;
import com.anydog.qaedu.data.model.api.request.base.LoginRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoogleLoginRequest extends LoginRequest<GooglePayload> {
    public GoogleLoginRequest(String gtoken, String deviceId, String email, String username, String avatar) {
        super(LoginType.google, deviceId, new GooglePayload(gtoken,email, username,avatar));
    }
}

class GooglePayload {
    @Expose
    @SerializedName("gtoken")
    private String gtoken;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("avatar")
    private String avatar;

    @Expose
    @SerializedName("about")
    private String about;


    public GooglePayload(String gtoken, String email, String username,String avatar) {
        this.gtoken = gtoken;
        this.username = username;
        this.email = email;
        this.about = "Nothing here";
        this.avatar = avatar;
    }
}
