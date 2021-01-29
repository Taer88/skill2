package com.anydog.qaedu.ui.feed.bucket;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anydog.qaedu.BR;
import com.anydog.qaedu.R;
import com.anydog.qaedu.ViewModelProviderFactory;
import com.anydog.qaedu.data.model.api.data.BucketItem;
import com.anydog.qaedu.databinding.FragmentBucketBinding;
import com.anydog.qaedu.ui.base.AdapterListener;
import com.anydog.qaedu.ui.base.BaseFragment;
import com.anydog.qaedu.ui.feed.base.ItemListener;

import java.util.List;

import javax.inject.Inject;

public class BucketFragment extends BaseFragment<FragmentBucketBinding, BucketViewModel>
        implements BucketNavigator, AdapterListener, ItemListener<BucketItem> {
    @Inject
    BucketAdapter adapter;
    @Inject
    LinearLayoutManager layoutManager;
    @Inject
    ViewModelProviderFactory factory;
    FragmentBucketBinding bindings;

    public BucketFragment() {
    }

    public static BucketFragment newInstance() {
        Bundle args = new Bundle();
        BucketFragment fragment = new BucketFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void Refresh() {
        getViewModel();
        if (viewModel == null) return;
        viewModel.fetch();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_bucket;
    }

    @Override
    public BucketViewModel getViewModel() {
        return ViewModelProviders.of(this, factory).get(BucketViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        adapter.setListener(this);
        viewModel.fetch();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindings = getViewDataBinding();
        setUp();
    }

    @Override
    public void update(List<BucketItem> items) {
        adapter.addItems(items);
    }

    private void setUp() {
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        bindings.recycler.setLayoutManager(layoutManager);
        bindings.recycler.setItemAnimator(new DefaultItemAnimator());
        bindings.recycler.setAdapter(adapter);
    }

    @Override
    public void onRetryClick() {
        viewModel.fetch();
    }

    @Override
    public void onItemClick(BucketItem item) {
        //viewModel.fetch();
    }

    @Override
    public void onAdd(BucketItem item) {
        viewModel.addItem(item.getId());
    }

    @Override
    public void onRemove(BucketItem item) {
        viewModel.removeItem(item.getId());
    }
}
