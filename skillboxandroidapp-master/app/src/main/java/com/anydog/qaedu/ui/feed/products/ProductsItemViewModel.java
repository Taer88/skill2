package com.anydog.qaedu.ui.feed.products;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.anydog.qaedu.data.model.api.data.Product;

public class ProductsItemViewModel {

    public final ProductsItemViewModelListener listener;
    public final ObservableField<Float> price;
    public final ObservableField<Boolean> discount;
    public final ObservableField<String> name;
    public final ObservableField<String> date;
    public final ObservableField<String> imageUrl;
    private final Product _product;

    public ProductsItemViewModel(Product product, ProductsItemViewModelListener listener) {
        this.listener = listener;
        _product = product;

        price = new ObservableField<>(product.getPrice());
        name = new ObservableField<>(product.getName());
        date = new ObservableField<>(product.getDate());
        discount = new ObservableField<>(product.getPerformance());
        imageUrl = new ObservableField<>(product.getProductImage());
    }

    public void onItemClick() {
        listener.onItemClick(_product.getId());
    }

    public interface ProductsItemViewModelListener {
        void onItemClick(String productId);
    }
}
