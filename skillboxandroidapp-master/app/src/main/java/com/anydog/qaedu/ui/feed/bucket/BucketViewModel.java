package com.anydog.qaedu.ui.feed.bucket;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.data.model.api.data.BucketItem;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

import java.util.List;

public class BucketViewModel extends BaseViewModel<BucketNavigator> {

    private final MutableLiveData<List<BucketItem>> liveListData;
    private final ObservableField<String> totalPrice = new ObservableField<>();

    public BucketViewModel(DataManager dataManager,
                           SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        liveListData = new MutableLiveData<>();
    }

    public MutableLiveData<List<BucketItem>> getLiveListData() {
        return liveListData;
    }

    public void fetch() {
        setIsLoading(true);
        Observe(getDataManager().getProfile(getDataManager().getProfileId()),
                response -> {
                    if (response != null && response.getInfo() != null) {
                        float total = 0;
                        for (BucketItem bucketItem : response.getInfo().getBucket()) {
                            total += bucketItem.getPrice() * 100;
                        }
                        total = Math.round(total) / 100f;
                        totalPrice.set(total + "$");
                        liveListData.setValue(response.getInfo().getBucket());
                    }
                }
        );
    }

    public ObservableField<String> getTotalPrice() {
        return totalPrice;
    }

    public void addItem(String itemId) {
    }

    public void removeItem(String itemId) {
    }
}
