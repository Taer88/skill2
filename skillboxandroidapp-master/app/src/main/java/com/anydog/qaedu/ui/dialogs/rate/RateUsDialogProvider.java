package com.anydog.qaedu.ui.dialogs.rate;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RateUsDialogProvider {

    @ContributesAndroidInjector
    abstract RateUsDialog provideRateUsDialogFactory();
}
