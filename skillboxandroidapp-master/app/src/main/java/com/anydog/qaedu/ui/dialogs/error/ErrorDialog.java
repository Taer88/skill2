package com.anydog.qaedu.ui.dialogs.error;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.anydog.qaedu.R;
import com.anydog.qaedu.ViewModelProviderFactory;
import com.anydog.qaedu.databinding.DialogErrorBinding;
import com.anydog.qaedu.ui.base.BaseUnhandledDialog;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class ErrorDialog extends BaseUnhandledDialog implements ErrorDialogCallback {

    private static final String TAG = ErrorDialog.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;

    private ErrorDialogViewModel viewModel;
    // TODO: just refactor it =)
    private String message;

    public static ErrorDialog newInstance(String message) {
        ErrorDialog fragment = new ErrorDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.message = message;
        return fragment;
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DialogErrorBinding binding = DataBindingUtil.inflate(inflater, R.layout.dialog_error, container, false);
        View view = binding.getRoot();

        //AndroidSupportInjection.inject(this);
        viewModel = ViewModelProviders.of(this, factory).get(ErrorDialogViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.setNavigator(this);
        viewModel.SetMessage(message);
        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }
}
