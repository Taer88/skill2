package com.anydog.qaedu;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.anydog.qaedu.data.DataManager;
import com.anydog.qaedu.ui.about.AboutViewModel;
import com.anydog.qaedu.ui.dialogs.error.ErrorDialogViewModel;
import com.anydog.qaedu.ui.dialogs.rate.RateUsViewModel;
import com.anydog.qaedu.ui.feed.FeedViewModel;
import com.anydog.qaedu.ui.feed.bucket.BucketViewModel;
import com.anydog.qaedu.ui.feed.products.ProductsViewModel;
import com.anydog.qaedu.ui.login.LoginViewModel;
import com.anydog.qaedu.ui.main.MainViewModel;
import com.anydog.qaedu.ui.product.ProductViewModel;
import com.anydog.qaedu.ui.product.comments.CommentsViewModel;
import com.anydog.qaedu.ui.profile.ProfileViewModel;
import com.anydog.qaedu.ui.splash.SplashViewModel;
import com.anydog.qaedu.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AboutViewModel.class)) {
            //noinspection unchecked
            return (T) new AboutViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(FeedViewModel.class)) {
            //noinspection unchecked
            return (T) new FeedViewModel(dataManager, schedulerProvider);

        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ProductsViewModel.class)) {
            //noinspection unchecked
            return (T) new ProductsViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(RateUsViewModel.class)) {
            //noinspection unchecked
            return (T) new RateUsViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ErrorDialogViewModel.class)) {
            //noinspection unchecked
            return (T) new ErrorDialogViewModel();
        } else if (modelClass.isAssignableFrom(ProfileViewModel.class)) {
            //noinspection unchecked
            return (T) new ProfileViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(BucketViewModel.class)) {
            //noinspection unchecked
            return (T) new BucketViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(ProductViewModel.class)) {
            //noinspection unchecked
            return (T) new ProductViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(CommentsViewModel.class)) {
            //noinspection unchecked
            return (T) new CommentsViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}