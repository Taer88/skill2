package com.anydog.qaedu.data.model.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Size {
    @Expose
    @SerializedName("width")
    private String width;
    @Expose
    @SerializedName("height")
    private String height;
}
