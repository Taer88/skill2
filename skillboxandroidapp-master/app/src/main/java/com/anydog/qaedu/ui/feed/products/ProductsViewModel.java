package com.anydog.qaedu.ui.feed.products;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.data.model.api.data.Product;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

import java.util.List;

public class ProductsViewModel extends BaseViewModel<ProductsNavigator> {

    private final MutableLiveData<List<Product>> liveListData;

    public ProductsViewModel(DataManager dataManager,
                             SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        liveListData = new MutableLiveData<>();
    }

    public void fetch(boolean actions) {
        setIsLoading(true);
        Observe(getDataManager().getProducts(actions),
                response -> {
                    if (response != null && response.getInfo() != null && response.getInfo().getProducts() != null) {
                        liveListData.setValue(response.getInfo().getProducts());
                    }
                }
        );
    }

    public LiveData<List<Product>> getLiveListData() {
        return liveListData;
    }
}
