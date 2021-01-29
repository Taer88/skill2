package com.anydog.qaedu.ui.feed.products;

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
import com.anydog.qaedu.data.model.api.data.Product;
import com.anydog.qaedu.databinding.FragmentProductsBinding;
import com.anydog.qaedu.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

public class ProductsFragment extends BaseFragment<FragmentProductsBinding, ProductsViewModel>
        implements ProductsNavigator, ProductsAdapter.ProductAdapterListener {

    boolean _actions;
    @Inject
    ProductsAdapter _adapter;
    @Inject
    LinearLayoutManager _layoutManager;
    @Inject
    ViewModelProviderFactory factory;
    FragmentProductsBinding _bindings;
    private ProductsViewModel _viewModel;

//    TODO: ORIENTATION CRASH BUG
    public ProductsFragment() {
    }

    public ProductsFragment(boolean actions) {
        this._actions = actions;
    }

    public static ProductsFragment newInstance(boolean actions) {
        Bundle args = new Bundle();
        ProductsFragment fragment = new ProductsFragment(actions);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_products;
    }

    @Override
    public ProductsViewModel getViewModel() {
        _viewModel = ViewModelProviders.of(this, factory).get(ProductsViewModel.class);
        return _viewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _viewModel.setNavigator(this);
        _adapter.setListener(this);
        _viewModel.fetch(_actions);
    }

    @Override
    public void onRetryClick() {
        _viewModel.fetch(_actions);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _bindings = getViewDataBinding();
        setUp();
    }

    @Override
    public void update(List<Product> products) {
        _adapter.addItems(products);
    }

    private void setUp() {
        _layoutManager.setOrientation(RecyclerView.VERTICAL);
        _bindings.ticketsRecyclerView.setLayoutManager(_layoutManager);
        _bindings.ticketsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        _bindings.ticketsRecyclerView.setAdapter(_adapter);
    }
}
