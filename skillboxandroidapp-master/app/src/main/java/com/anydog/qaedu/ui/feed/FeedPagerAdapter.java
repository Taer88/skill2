package com.anydog.qaedu.ui.feed;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.anydog.qaedu.ui.base.BaseFragment;
import com.anydog.qaedu.ui.feed.bucket.BucketFragment;
import com.anydog.qaedu.ui.feed.products.ProductsFragment;
import com.anydog.qaedu.ui.profile.ProfileFragment;

import java.util.HashMap;
import java.util.Map;

public class FeedPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;
    private Map<Integer, BaseFragment> _fragments = new HashMap<Integer, BaseFragment>();

    public FeedPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 3;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }

    public void cleanup() {
        _fragments.clear();
    }

    @Override
    public BaseFragment getItem(int position) {
        createFragment(position);
        return _fragments.get(position);
    }

    private void createFragment(int position) {
        if (_fragments.containsKey(position))
            return;
        switch (position) {
            case 0:
                _fragments.put(0, ProductsFragment.newInstance(false));
            case 1:
                _fragments.put(1, ProfileFragment.newInstance());
            case 2:
                _fragments.put(2, ProductsFragment.newInstance(true));
            case 3:
                _fragments.put(3, BucketFragment.newInstance());
        }
    }
}
