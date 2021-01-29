package com.anydog.qaedu.ui.feed.products;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ProductsFragmentProvider {

    @ContributesAndroidInjector(modules = ProductsFragmentModule.class)
    abstract ProductsFragment provideProductsFragmentFactory();
}
