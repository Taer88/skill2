package com.anydog.qaedu.ui.product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.anydog.qaedu.BR;
import com.anydog.qaedu.R;
import com.anydog.qaedu.ViewModelProviderFactory;
import com.anydog.qaedu.databinding.ActivityProductBinding;
import com.anydog.qaedu.ui.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class ProductActivity extends BaseActivity<ActivityProductBinding, ProductViewModel> implements ProductNavigator, HasSupportFragmentInjector {

    public static String ProductIdKey = "productIdKey";
    public static String JustInfoKey = "justInfo";
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    private ProductViewModel viewModel;
    private ActivityProductBinding _binding;

    public static Intent newIntent(Context context, String productId, boolean justInfo) {
        Intent intent = new Intent(context, ProductActivity.class);
        intent.putExtra(ProductIdKey, productId);
        intent.putExtra(JustInfoKey, justInfo);
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_product;
    }

    @Override
    public ProductViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(ProductViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String productId = getIntent().getStringExtra(ProductIdKey);
        _binding = getViewDataBinding();
        if (getIntent().getBooleanExtra(JustInfoKey, false)) {
            viewModel.setJustInfoMode();
        }


        viewModel.setNavigator(this);
        viewModel.fetch(productId);
    }

    @Override
    public void back() {
        finish();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
