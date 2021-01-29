package com.anydog.qaedu.ui.feed.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.anydog.qaedu.databinding.EmptyViewBinding;
import com.anydog.qaedu.ui.base.BaseViewHolder;
import com.anydog.qaedu.ui.empty.EmptyViewHolder;

import java.util.List;

public abstract class BaseRecycleAdapter<T,TL extends ItemListener<T>> extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    protected List<T> _itemsList;
    protected TL _listener;

    public BaseRecycleAdapter(List<T> items) {
        _itemsList = items;
    }

    @Override
    public int getItemCount() {
        if (_itemsList != null && _itemsList.size() > 0) {
            return _itemsList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (_itemsList != null && !_itemsList.isEmpty()) {
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
                return createItemViewHolder(parent);
            case VIEW_TYPE_EMPTY:
            default:
                EmptyViewBinding emptyViewBinding = EmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    protected abstract BaseViewHolder createItemViewHolder(ViewGroup holder);

    public void addItems(List<T> item) {
        _itemsList.addAll(item);
        notifyDataSetChanged();
    }

    public void clearItems() {
        _itemsList.clear();
    }

    public void setListener(TL listener) {
        this._listener = listener;
    }
}
