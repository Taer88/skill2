package com.anydog.qaedu.ui.profile;

import com.anydog.qaedu.utils.ErrorHandlerNavigator;
import com.anydog.qaedu.utils.LogoutNavigator;

public interface ProfileNavigator extends ErrorHandlerNavigator, LogoutNavigator {

    void changeName();

    void goBack();

    void getImage();

}
