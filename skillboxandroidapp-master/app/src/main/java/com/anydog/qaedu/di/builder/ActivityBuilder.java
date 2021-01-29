package com.anydog.qaedu.di.builder;

import com.anydog.qaedu.ui.about.AboutFragmentProvider;
import com.anydog.qaedu.ui.dialogs.error.ErrorDialogProvider;
import com.anydog.qaedu.ui.dialogs.rate.RateUsDialogProvider;
import com.anydog.qaedu.ui.feed.FeedActivity;
import com.anydog.qaedu.ui.feed.FeedActivityModule;
import com.anydog.qaedu.ui.feed.bucket.BucketFragmentProvider;
import com.anydog.qaedu.ui.feed.products.ProductsFragmentProvider;
import com.anydog.qaedu.ui.login.LoginActivity;
import com.anydog.qaedu.ui.main.MainActivity;
import com.anydog.qaedu.ui.product.ProductActivity;
import com.anydog.qaedu.ui.product.comments.CommentsFragmentProvider;
import com.anydog.qaedu.ui.profile.ProfileFragment;
import com.anydog.qaedu.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            FeedActivityModule.class,
            ErrorDialogProvider.class,
            BucketFragmentProvider.class,
            ProductsFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

    @ContributesAndroidInjector(modules = {
            ErrorDialogProvider.class
    })
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {
            ErrorDialogProvider.class
    })
    abstract ProfileFragment bindProfileActivity();

    @ContributesAndroidInjector(modules = {
            AboutFragmentProvider.class,
            RateUsDialogProvider.class,
            ErrorDialogProvider.class
    })
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {
            ErrorDialogProvider.class,
            CommentsFragmentProvider.class
    })
    abstract ProductActivity bindProductActivity();

    @ContributesAndroidInjector(modules = {
            ErrorDialogProvider.class
    })
    abstract SplashActivity bindSplashActivity();
}
