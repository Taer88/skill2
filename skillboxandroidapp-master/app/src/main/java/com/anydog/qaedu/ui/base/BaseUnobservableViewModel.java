package com.anydog.qaedu.ui.base;

import androidx.databinding.ObservableBoolean;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseUnobservableViewModel<N> extends BaseNavigatedViewModel<N> {

    private final DataManager dataManager;
    private final ObservableBoolean isLoading = new ObservableBoolean();
    private final SchedulerProvider schedulerProvider;

    private CompositeDisposable compositeDisposable;
    private WeakReference<N> navigator;

    public BaseUnobservableViewModel(DataManager dataManager,
                                     SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }
}
