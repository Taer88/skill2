package com.anydog.qaedu.ui.dialogs.error;

import androidx.databinding.ObservableField;

import com.anydog.qaedu.ui.base.BaseNavigatedViewModel;

public class ErrorDialogViewModel extends BaseNavigatedViewModel<ErrorDialogCallback> {

    private final ObservableField<String> errorText;

    public ErrorDialogViewModel() {
        this.errorText = new ObservableField<>();
    }

    public ObservableField<String> getErrorText() {
        return errorText;
    }

    public void SetMessage(String message) {
        this.errorText.set(message);
    }

    public void onCloseClick() {
        getNavigator().dismissDialog();
    }
}
