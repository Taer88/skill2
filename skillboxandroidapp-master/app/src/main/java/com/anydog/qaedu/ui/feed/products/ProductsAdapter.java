package com.anydog.qaedu.ui.feed.products;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.anydog.qaedu.QaEduApplication;
import com.anydog.qaedu.data.model.api.data.Product;
import com.anydog.qaedu.databinding.EmptyViewBinding;
import com.anydog.qaedu.databinding.ItemProductViewBinding;
import com.anydog.qaedu.ui.base.BaseViewHolder;
import com.anydog.qaedu.ui.empty.EmptyViewHolder;
import com.anydog.qaedu.ui.product.ProductActivity;
import com.anydog.qaedu.utils.AppLogger;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private List<Product> _products;
    private ProductAdapterListener _listener;

    public ProductsAdapter(List<Product> product) {
        _products = product;
    }

    @Override
    public int getItemCount() {
        if (_products != null && _products.size() > 0) {
            return _products.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (_products != null && !_products.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemProductViewBinding viewBinding = ItemProductViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new ProductsViewHolder(viewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                EmptyViewBinding emptyViewBinding = EmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<Product> product) {
        _products.addAll(product);
        notifyDataSetChanged();
    }

    public void clearItems() {
        _products.clear();
    }

    public void setListener(ProductAdapterListener listener) {
        this._listener = listener;
    }

    public interface ProductAdapterListener {

        void onRetryClick();
    }

    public class ProductsViewHolder extends BaseViewHolder implements ProductsItemViewModel.ProductsItemViewModelListener {
        private ItemProductViewBinding binding;
        private ProductsItemViewModel vm;

        public ProductsViewHolder(ItemProductViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            final Product product = _products.get(position);
            vm = new ProductsItemViewModel(product, this);
            binding.setViewModel(vm);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            binding.executePendingBindings();
        }

        @Override
        public void onItemClick(String productId) {
            if (productId != null) {
                try {
                    Intent intent = ProductActivity.newIntent(QaEduApplication.getAppContext(), productId, false);
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("Missed product");
                }
            }
        }
    }
}