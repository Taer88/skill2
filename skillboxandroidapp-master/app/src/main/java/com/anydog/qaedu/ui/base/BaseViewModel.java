package com.anydog.qaedu.ui.base;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.data.model.api.base.ApiResponse;
import com.anydog.qaedu.data.model.api.base.RestStatus;
import com.anydog.qaedu.utils.ErrorHandlerNavigator;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public abstract class BaseViewModel<N extends ErrorHandlerNavigator> extends BaseUnobservableViewModel<N> {

    public BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    protected <T extends ApiResponse> void Observe(Single<T> single, Consumer<? super T> resp) {
        getCompositeDisposable().add(single
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                //.doOnSuccess(resp)
                .doOnError(error -> {
                    setIsLoading(false);
                    if (error instanceof ANError) {
                        ANError e = ((ANError) error);
                        String message = e.getResponse().message() + "\n" + e.getErrorBody();
                        getNavigator().handleApiError(message);
                    } else {
                        getNavigator().handleApiError(error.toString());
                    }
                })
                .subscribe(
                        response -> {
                            if (response.getResult() == RestStatus.error) {
                                setIsLoading(false);
                                Log.d("ObserveVM", "THIS CASTLE UNACCEPTABLE CONDITION!" + response.getCode());
                                getNavigator().handleApiError(response.getCode());
                            } else {
                                setIsLoading(false);
                                resp.accept(response);
                            }
                        },
                        throwable -> {
//                            getNavigator().handleApiError(throwable.getMessage());
//                            setIsLoading(false);
                        }));

    }
}