package com.anydog.qaedu.ui.feed.bucket;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BucketFragmentProvider {

    @ContributesAndroidInjector(modules = BucketFragmentModule.class)
    abstract BucketFragment provideBucketFragmentFactory();
}
