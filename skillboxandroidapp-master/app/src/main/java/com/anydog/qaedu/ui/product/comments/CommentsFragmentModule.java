package com.anydog.qaedu.ui.product.comments;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.anydog.qaedu.ui.product.ProductActivity;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class CommentsFragmentModule {

    @Provides
    CommentsAdapter provideCommentsAdapter(ProductActivity activity) {
        return new CommentsAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(ProductActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
