package com.anydog.qaedu.ui.feed.products;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductsFragmentModule {

    @Provides
    ProductsAdapter provideProductsAdapter() {
        return new ProductsAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(ProductsFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
