package com.anydog.qaedu.data.rest;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("result")
    private RestStatus status;
    @SerializedName("info")
    private T result;

    public Boolean isOk() {
        return status == RestStatus.ok;
    }

    public String getError() {

        if (status == RestStatus.error) {
            return result.toString();
        }
        return "No errors";
    }

    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        switch (status) {
            case ok:
                return "OK : " + result;
            case error:
                return "Error : " + result;
            default:
                return "UNKNOWN STATUS";
        }
    }

    enum RestStatus {
        ok,
        error
    }
}
