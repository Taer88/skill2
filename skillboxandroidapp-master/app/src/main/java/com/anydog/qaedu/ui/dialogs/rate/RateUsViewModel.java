package com.anydog.qaedu.ui.dialogs.rate;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

public class RateUsViewModel extends BaseViewModel<RateUsCallback> {

    public RateUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onLaterClick() {
        getNavigator().dismissDialog();
    }

    public void onSubmitClick() {
        getNavigator().dismissDialog();
    }
}
