package com.anydog.qaedu.ui.product.comments;

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
import com.anydog.qaedu.data.model.api.data.CommentItem;
import com.anydog.qaedu.databinding.FragmentCommentsBinding;
import com.anydog.qaedu.ui.base.BaseFragment;
import com.anydog.qaedu.ui.product.ProductActivity;

import java.util.List;

import javax.inject.Inject;

public class CommentsFragment extends BaseFragment<FragmentCommentsBinding, CommentsViewModel>
        implements CommentsNavigator, CommentsItemListener<CommentItem> {
    @Inject
    CommentsAdapter adapter;
    @Inject
    LinearLayoutManager layoutManager;
    @Inject
    ViewModelProviderFactory factory;
    FragmentCommentsBinding bindings;

    public CommentsFragment() {
    }

    public static CommentsFragment newInstance() {
        Bundle args = new Bundle();
        CommentsFragment fragment = new CommentsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void Refresh() {
        getViewModel();
        if (viewModel == null) return;
        fetch();
    }

    private void fetch() {
        String key = getBaseActivity().getIntent().getStringExtra(ProductActivity.ProductIdKey);
        viewModel.fetch(key);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comments;
    }

    @Override
    public CommentsViewModel getViewModel() {
        return ViewModelProviders.of(this, factory).get(CommentsViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        adapter.setListener(this);
        fetch();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindings = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        bindings.commentsView.setLayoutManager(layoutManager);
        bindings.commentsView.setItemAnimator(new DefaultItemAnimator());
        bindings.commentsView.setAdapter(adapter);
    }

    @Override
    public void update(List<CommentItem> items) {
    }

    @Override
    public void onItemClick(CommentItem item) {

    }

    @Override
    public void onAdd(CommentItem item) {

    }

    @Override
    public void onRemove(CommentItem item) {

    }

    @Override
    public void onReply(CommentItem item, String text) {
        viewModel.sendReply(item,text);
    }
}


