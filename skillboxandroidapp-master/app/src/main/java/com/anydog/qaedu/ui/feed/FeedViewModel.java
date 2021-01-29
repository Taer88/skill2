package com.anydog.qaedu.ui.feed;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

public class FeedViewModel extends BaseViewModel<FeedNavigator> {
    public FeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void fetch() {
        if (getDataManager().getProfileId() == null) {
            getDataManager().doLogoutApiCall();
        } else {
            getNavigator().setUp();
        }
    }
}
