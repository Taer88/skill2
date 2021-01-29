package com.anydog.qaedu.ui.feed.bucket;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.anydog.qaedu.QaEduApplication;
import com.anydog.qaedu.data.model.api.data.BucketItem;
import com.anydog.qaedu.databinding.ItemBucketViewBinding;
import com.anydog.qaedu.ui.base.BaseViewHolder;
import com.anydog.qaedu.ui.feed.base.BaseRecycleAdapter;
import com.anydog.qaedu.ui.feed.base.ItemListener;
import com.anydog.qaedu.ui.product.ProductActivity;
import com.anydog.qaedu.utils.AppLogger;

import java.util.List;

public class BucketAdapter extends BaseRecycleAdapter<BucketItem, ItemListener<BucketItem>> {

    public BucketAdapter(List items) {
        super(items);
    }

    @Override
    protected BaseViewHolder createItemViewHolder(ViewGroup parent) {
        ItemBucketViewBinding viewBinding = ItemBucketViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new BucketViewHolder(viewBinding);
    }

    public class BucketViewHolder extends BaseViewHolder implements ItemListener<BucketItem> {
        private ItemBucketViewBinding binding;
        private BucketItemViewModel vm;

        public BucketViewHolder(ItemBucketViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            final BucketItem item = _itemsList.get(position);
            vm = new BucketItemViewModel(item, this);
            binding.setViewModel(vm);
            binding.executePendingBindings();
        }

        @Override
        public void onItemClick(BucketItem item) {
            String productId = item.getProductId();
            if (productId != null) {
                try {
                    Intent intent = ProductActivity.newIntent(QaEduApplication.getAppContext(), productId, true);
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("Missed product");
                }
            }
        }

        @Override
        public void onAdd(BucketItem item) {

        }

        @Override
        public void onRemove(BucketItem item) {

        }
    }

}
