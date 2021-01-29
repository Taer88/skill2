package com.anydog.qaedu.ui.splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.anydog.qaedu.BR;
import com.anydog.qaedu.R;
import com.anydog.qaedu.ViewModelProviderFactory;
import com.anydog.qaedu.databinding.ActivitySplashBinding;
import com.anydog.qaedu.ui.base.BaseActivity;
import com.anydog.qaedu.ui.feed.FeedActivity;
import com.anydog.qaedu.ui.login.LoginActivity;
import com.anydog.qaedu.ui.main.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    ViewModelProviderFactory factory;

    private SplashViewModel _vm;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        _vm = ViewModelProviders.of(this, factory).get(SplashViewModel.class);
        return _vm;
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = FeedActivity.newIntent(SplashActivity.this);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _vm.setNavigator(this);
        _vm.startSeeding();

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},     0);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},     1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},     2);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},     3);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},     4);

    }
}
