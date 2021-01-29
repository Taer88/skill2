package com.anydog.qaedu.ui.dialogs.error;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ErrorDialogProvider {

    @ContributesAndroidInjector
    abstract ErrorDialog provideErrorDialogFactory();
}
