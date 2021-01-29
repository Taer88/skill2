package com.anydog.qaedu.data.model.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination {
    @Expose
    @SerializedName("records")
    int records;

    @Expose
    @SerializedName("per_page")
    int per_page;

    @Expose
    @SerializedName("current_page")
    int current_page;
}
