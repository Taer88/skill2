package com.anydog.qaedu.data.rest.types;

import com.google.gson.annotations.SerializedName;

public class UserDetails {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    public String get_id() {
        return id;
    }

    public String get_name() {
        return name;
    }

    @Override
    public String toString() {
        return "UserDetails : id:" + id + "; name:" + name;
    }
}