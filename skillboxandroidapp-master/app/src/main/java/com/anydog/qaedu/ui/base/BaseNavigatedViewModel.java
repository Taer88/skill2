package com.anydog.qaedu.ui.base;

import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

public abstract class BaseNavigatedViewModel<N> extends ViewModel {

    private WeakReference<N> navigator;

    public N getNavigator() {
        return navigator.get();
    }

    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }
}
