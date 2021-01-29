package com.anydog.qaedu.ui.login;

import com.anydog.qaedu.utils.ErrorHandlerNavigator;

public interface LoginNavigator extends ErrorHandlerNavigator {

    void emailLogin();

    void emailRegister();

    void googleSign();

    void openMainActivity();

}
