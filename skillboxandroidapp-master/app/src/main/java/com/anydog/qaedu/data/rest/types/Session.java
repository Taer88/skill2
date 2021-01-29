package com.anydog.qaedu.data.rest.types;

import com.google.gson.annotations.SerializedName;

public class Session {
    @SerializedName("session_id")
    private String id;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Session : id:" + id;
    }
}
