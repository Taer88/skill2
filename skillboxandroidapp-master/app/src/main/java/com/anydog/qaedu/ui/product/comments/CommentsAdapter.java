package com.anydog.qaedu.ui.product.comments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.anydog.qaedu.data.model.api.data.CommentItem;
import com.anydog.qaedu.databinding.ItemCommentViewBinding;
import com.anydog.qaedu.ui.base.BaseViewHolder;
import com.anydog.qaedu.ui.feed.base.BaseRecycleAdapter;

import java.util.List;

public class CommentsAdapter extends BaseRecycleAdapter<CommentItem, CommentsItemListener<CommentItem>> {

    public CommentsAdapter(List items) {
        super(items);
    }

    @Override
    protected BaseViewHolder createItemViewHolder(ViewGroup parent) {
        ItemCommentViewBinding viewBinding = ItemCommentViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new CommentViewHolder(viewBinding);
    }

    public class CommentViewHolder extends BaseViewHolder implements CommentsItemListener<CommentItem> {
        private ItemCommentViewBinding binding;
        private CommentItemViewModel vm;

        public CommentViewHolder(ItemCommentViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            final CommentItem item = _itemsList.get(position);
            vm = new CommentItemViewModel(item, this);
            binding.setViewModel(vm);
            binding.executePendingBindings();
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
            _listener.onReply(item, text);
        }
    }

}

