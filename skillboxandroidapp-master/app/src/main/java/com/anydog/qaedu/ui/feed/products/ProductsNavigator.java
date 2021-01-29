package com.anydog.qaedu.ui.feed.products;

import com.anydog.qaedu.data.model.api.data.Product;
import com.anydog.qaedu.utils.ErrorHandlerNavigator;

import java.util.List;

public interface ProductsNavigator extends ErrorHandlerNavigator {
    void update(List<Product> products);
}
