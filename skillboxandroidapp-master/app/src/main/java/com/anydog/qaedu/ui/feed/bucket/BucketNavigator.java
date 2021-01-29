package com.anydog.qaedu.ui.feed.bucket;

import com.anydog.qaedu.data.model.api.data.BucketItem;
import com.anydog.qaedu.utils.ErrorHandlerNavigator;

import java.util.List;

public interface BucketNavigator extends ErrorHandlerNavigator {
    void update(List<BucketItem> items);
}
