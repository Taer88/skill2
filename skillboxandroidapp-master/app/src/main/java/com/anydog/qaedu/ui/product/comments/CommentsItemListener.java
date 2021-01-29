package com.anydog.qaedu.ui.product.comments;

import com.anydog.qaedu.ui.feed.base.ItemListener;

public interface CommentsItemListener<T> extends ItemListener<T> {
    void onReply(T item, String text);
}
