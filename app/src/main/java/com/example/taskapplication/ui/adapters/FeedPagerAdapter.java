package com.example.taskapplication.ui.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.taskapplication.ui.fragments.ChannelsFragment;
import com.example.taskapplication.ui.fragments.SocialFragment;

public class FeedPagerAdapter extends FragmentStatePagerAdapter {
    private int mTabCount;

    public FeedPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ChannelsFragment.newInstance();
            case 1:
                return SocialFragment.newInstance();
            default:
                return null;
        }
    }
}
