package com.anydog.qaedu.ui.product;

import androidx.databinding.ObservableField;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.data.model.api.data.BucketItem;
import com.anydog.qaedu.data.model.api.data.Product;
import com.anydog.qaedu.ui.base.BaseViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

public class ProductViewModel extends BaseViewModel<ProductNavigator> {
    private static final String TAG = "MainViewModel";
    private final ObservableField<Float> price = new ObservableField<>();
    private final ObservableField<Boolean> discount = new ObservableField<>();
    private final ObservableField<String> name = new ObservableField<>();
    private final ObservableField<String> date = new ObservableField<>();
    private final ObservableField<String> imageUrl = new ObservableField<>();


    private final ObservableField<Boolean> justInfo = new ObservableField<>();


    private String productId;
    private boolean justInfoMode;

    public ProductViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public ObservableField<Float> getPrice() {
        return price;
    }

    public ObservableField<Boolean> getDiscount() {
        return discount;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getDate() {
        return date;
    }

    public ObservableField<String> getImageUrl() {
        return imageUrl;
    }

    public ObservableField<Boolean> getJustInfo() {
        return justInfo;
    }

    public void fetch(String productId) {
        this.productId = productId;
        setIsLoading(true);
        Observe(getDataManager().getProduct(productId),
                response -> {
                    if (response != null && response.getInfo() != null) {
                        Product p = response.getInfo();
                        price.set(p.getPrice());
                        discount.set(p.getPerformance());
                        name.set(p.getName());
                        date.set(p.getDate());
                        imageUrl.set(p.getProductImage());
                        justInfo.set(justInfoMode);
                    }
                }
        );
    }

    public void setJustInfoMode() {
        justInfoMode = true;
    }

    public void addToCart() {

        Observe(getDataManager().addToCart(productId),
                response -> {
                    if (response != null && response.getInfo() != null) {
                        BucketItem p = response.getInfo();
                        getNavigator().back();
                    }
                }
        );
    }
}
