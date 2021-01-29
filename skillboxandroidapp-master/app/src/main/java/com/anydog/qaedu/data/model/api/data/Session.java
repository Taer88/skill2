package com.anydog.qaedu.data.model.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Session {
    @Expose
    @SerializedName("session_id")
    private String session;

    public String getSession() {
        return session;
    }
}
