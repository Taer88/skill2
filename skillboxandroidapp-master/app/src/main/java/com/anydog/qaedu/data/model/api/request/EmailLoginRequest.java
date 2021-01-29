package com.anydog.qaedu.data.model.api.request;

import com.anydog.qaedu.data.model.api.data.LoginType;
import com.anydog.qaedu.data.model.api.request.base.LoginRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailLoginRequest extends LoginRequest<EmailPayload> {
    public EmailLoginRequest(String email, String pass, String deviceId) {
        super(LoginType.email, deviceId,new EmailPayload(email, pass));
    }
}

class EmailPayload {
    @Expose
    @SerializedName("login")
    private String login;

    @Expose
    @SerializedName("password")
    private String password;

    public EmailPayload(String email, String password) {
        this.login = email;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
