package com.anydog.qaedu.ui.product.comments;


import androidx.databinding.ObservableField;

import com.anydog.qaedu.data.model.api.data.CommentItem;
import com.google.android.material.textfield.TextInputEditText;

public class CommentItemViewModel {
    public final CommentsItemListener<CommentItem> listener;
    public final ObservableField<String> userName;
    public final ObservableField<String> text;
    public final ObservableField<String> productId;
    public final ObservableField<Boolean> showReply;
    //public final ObservableField<String> userId;
    private final SubCommentsAdapter subCommentsAdapter;
    private final CommentItem item;

    public CommentItemViewModel(CommentItem item, CommentsItemListener<CommentItem> listener) {
        this.listener = listener;
        this.item = item;
        userName = new ObservableField<>(item.getUserName());
        text = new ObservableField<>(item.getText());
        subCommentsAdapter = new SubCommentsAdapter(item.getSubComments());
        productId = new ObservableField<>(item.getProductId());
        showReply = new ObservableField<>();
        //userId = new ObservableField<>(item.getUserId());
    }

    public SubCommentsAdapter getSubCommentsAdapter() {
        return subCommentsAdapter;
    }

    public CommentsItemListener<CommentItem> getListener() {
        return listener;
    }

    public void onItemClick() {
        listener.onItemClick(item);
    }

    public void sendReply(String text) {
        listener.onReply(item, text);
    }

    public void showReplyField() {
        showReply.set(true);
    }
}

