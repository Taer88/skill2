package com.anydog.qaedu.ui.feed;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.anydog.qaedu.BR;
import com.anydog.qaedu.R;
import com.anydog.qaedu.ViewModelProviderFactory;
import com.anydog.qaedu.databinding.ActivityFeedBinding;
import com.anydog.qaedu.ui.base.BaseActivity;
import com.anydog.qaedu.ui.base.BaseFragment;
import com.anydog.qaedu.utils.AppUtils;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import static android.Manifest.*;

public class FeedActivity extends BaseActivity<ActivityFeedBinding, FeedViewModel> implements HasSupportFragmentInjector, FeedNavigator {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    FeedPagerAdapter pageAdapter;
    @Inject
    ViewModelProviderFactory factory;
    private int _pos;
    private ActivityFeedBinding _binding;
    private FeedViewModel viewModel;

    private boolean _created;

    public static Intent newIntent(Context context) {
        return new Intent(context, FeedActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        pageAdapter.cleanup();
        super.onDestroy();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_feed;
    }

    @Override
    public FeedViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(FeedViewModel.class);
        return viewModel;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                upIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                } else {
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = getViewDataBinding();
        viewModel.setNavigator(this);
        requestPermissionsSafely(new String[]{permission.WRITE_EXTERNAL_STORAGE},0);
        if (!hasPermission( permission.WRITE_EXTERNAL_STORAGE)){
            AppUtils.crash();
        }
        fetch();
    }

    private void fetch() {
        if (isNetworkConnected()) {
            viewModel.fetch();
        } else {
            handleApiError("Wrong api call!");
        }
    }

    @Override
    public void setUp() {
        //setSupportActionBar(_binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // TODO:  HERE COUNTER!!!!
        pageAdapter.setCount(4);

        _binding.feedViewPager.setAdapter(pageAdapter);

        _binding.tabLayout.addTab(_binding.tabLayout.newTab().setText(getString(R.string.products)));
        _binding.tabLayout.addTab(_binding.tabLayout.newTab().setText(getString(R.string.profile)));
        _binding.tabLayout.addTab(_binding.tabLayout.newTab().setText(getString(R.string.sale)));
        _binding.tabLayout.addTab(_binding.tabLayout.newTab().setText(getString(R.string.bucket)));

        _binding.feedViewPager.setOffscreenPageLimit(_binding.tabLayout.getTabCount());

        _binding.feedViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(_binding.tabLayout));

        _binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                _pos = tab.getPosition();
                _binding.feedViewPager.setCurrentItem(_pos);
                BaseFragment fragment = pageAdapter.getItem(_pos);
                fragment.Refresh();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
    }
}
