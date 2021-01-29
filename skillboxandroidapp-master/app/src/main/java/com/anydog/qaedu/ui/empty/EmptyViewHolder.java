package com.anydog.qaedu.ui.empty;

import com.anydog.qaedu.databinding.EmptyViewBinding;
import com.anydog.qaedu.ui.base.BaseViewHolder;

public class EmptyViewHolder extends BaseViewHolder implements EmptyItemViewModel.EmptyItemViewModelListener {

    private EmptyViewBinding binding;

    public EmptyViewHolder(EmptyViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void onBind(int position) {
        EmptyItemViewModel emptyItemViewModel = new EmptyItemViewModel(this);
        binding.setViewModel(emptyItemViewModel);
    }

    @Override
    public void onRetryClick() {
        //_listener.onRetryClick();
    }
}