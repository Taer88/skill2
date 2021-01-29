package com.anydog.qaedu.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.anydog.qaedu.ui.dialogs.error.ErrorDialog;
import com.anydog.qaedu.ui.login.LoginActivity;
import com.anydog.qaedu.utils.ErrorHandlerNavigator;
import com.anydog.qaedu.utils.LogoutNavigator;
import com.anydog.qaedu.utils.RefreshHandler;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment implements ErrorHandlerNavigator, LogoutNavigator, RefreshHandler {

    private BaseActivity mActivity;
    private View rootView;
    private T bindings;
    protected V viewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void Refresh(){

    }

    @Override
    public void logout() {
        startActivity(LoginActivity.newIntent(getBaseActivity().getBaseContext()));
        getBaseActivity().finish();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        viewModel = getViewModel();
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindings = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        rootView = bindings.getRoot();
        return rootView;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindings.setVariable(getBindingVariable(), viewModel);
        bindings.setLifecycleOwner(this);
        bindings.executePendingBindings();
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public T getViewDataBinding() {
        return bindings;
    }

    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    public boolean isNetworkConnected() {
        return mActivity != null && mActivity.isNetworkConnected();
    }

    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    private void performDependencyInjection() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void handleException(Throwable throwable) {
        ErrorDialog.newInstance(throwable.getMessage()).show(getFragmentManager());
    }

    @Override
    public void handleApiError(String errorCode) {
        ErrorDialog.newInstance(errorCode).show(getFragmentManager());
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
