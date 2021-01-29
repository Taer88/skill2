package com.anydog.qaedu.ui.feed.bucket;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class BucketFragmentModule {

    @Provides
    BucketAdapter provideBucketAdapter() {
        return new BucketAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(BucketFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
