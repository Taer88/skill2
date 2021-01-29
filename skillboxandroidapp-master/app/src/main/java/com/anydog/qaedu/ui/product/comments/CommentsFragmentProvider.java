package com.anydog.qaedu.ui.product.comments;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CommentsFragmentProvider {
    @ContributesAndroidInjector(modules = CommentsFragmentModule.class)
    abstract CommentsFragment provideCommentsFragmentFactory();

}
