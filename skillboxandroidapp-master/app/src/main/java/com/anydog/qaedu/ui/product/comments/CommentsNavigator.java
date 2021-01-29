package com.anydog.qaedu.ui.product.comments;

import com.anydog.qaedu.data.model.api.data.CommentItem;
import com.anydog.qaedu.utils.ErrorHandlerNavigator;

import java.util.List;

public interface CommentsNavigator extends ErrorHandlerNavigator {
    void update(List<CommentItem> items);
}
