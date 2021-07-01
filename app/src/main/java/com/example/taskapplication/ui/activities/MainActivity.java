package com.example.taskapplication.ui.activities;

import android.os.Bundle;
import com.example.taskapplication.BR;
import com.example.taskapplication.R;
import com.example.taskapplication.databinding.ActivityMainBinding;
import com.example.taskapplication.di.components.ActivityComponent;
import com.example.taskapplication.ui.adapters.FeedPagerAdapter;
import com.example.taskapplication.viewModels.MainViewModel;
import com.google.android.material.tabs.TabLayout;
import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Inject
    FeedPagerAdapter mPagerAdapter;
    private ActivityMainBinding binding;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
        setUp();
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    private void setUp() {
        setSupportActionBar(binding.toolbar);
        mPagerAdapter.setCount(2);
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Channels"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Socials"));
        binding.feedViewPager.setOffscreenPageLimit(binding.tabLayout.getTabCount());
        binding.feedViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.feedViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
        });
    }
}