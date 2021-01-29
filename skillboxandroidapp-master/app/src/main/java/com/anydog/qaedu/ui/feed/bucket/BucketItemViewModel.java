package com.anydog.qaedu.ui.feed.bucket;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.anydog.qaedu.data.model.api.data.BucketItem;
import com.anydog.qaedu.ui.feed.base.ItemListener;

public class BucketItemViewModel {
    public final ItemListener<BucketItem> listener;
    public final ObservableField<Float> price;
    public final ObservableField<String> name;
    public final ObservableField<Integer> count;
    public final ObservableField<String> imageId;
    private final BucketItem _item;

    public BucketItemViewModel(BucketItem item, ItemListener<BucketItem> listener) {
        this.listener = listener;
        _item = item;
        price = new ObservableField<>(item.getPrice());
        name = new ObservableField<>(item.getProductId());
        count = new ObservableField<>(item.getCount());
        imageId = new ObservableField<>(item.getImageUri());
    }

    public ItemListener<BucketItem> getListener() {
        return listener;
    }

    public void onItemClick() {
        Log.d("Bucket", "Item was clicked" + name);
        listener.onItemClick(_item);
    }

    public void onAdd() {
        Log.d("Bucket", "Adding" + name);
        listener.onAdd(_item);
    }

    public void onRemove() {
        Log.d("Bucket", "Removing" + name);
        listener.onRemove(_item);
    }
}
