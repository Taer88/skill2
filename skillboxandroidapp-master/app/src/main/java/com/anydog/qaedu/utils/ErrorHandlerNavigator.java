package com.anydog.qaedu.utils;

public interface ErrorHandlerNavigator {
    void handleException(Throwable throwable);

    void handleApiError(String errorCode);
}
