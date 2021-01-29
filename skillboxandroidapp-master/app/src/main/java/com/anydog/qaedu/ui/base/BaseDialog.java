package com.anydog.qaedu.ui.base;

import com.anydog.qaedu.ui.dialogs.error.ErrorDialog;
import com.anydog.qaedu.utils.ErrorHandlerNavigator;

public abstract class BaseDialog extends BaseUnhandledDialog implements ErrorHandlerNavigator {
    @Override
    public void handleException(Throwable throwable) {
        ErrorDialog.newInstance(throwable.getMessage()).show(getFragmentManager());
    }

    @Override
    public void handleApiError(String errorCode) {
        ErrorDialog.newInstance(errorCode).show(getFragmentManager());
    }


}
