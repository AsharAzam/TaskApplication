package com.example.taskapplication.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.taskapplication.BR;
import com.example.taskapplication.R;
import com.example.taskapplication.data.network.models.SocialModel;
import com.example.taskapplication.databinding.FragmentSocialBinding;
import com.example.taskapplication.di.components.FragmentComponent;
import com.example.taskapplication.ui.adapters.SocialAdapter;
import com.example.taskapplication.viewModels.ChannelsViewModel;
import com.example.taskapplication.viewModels.SocialViewModel;


import javax.inject.Inject;

public class SocialFragment extends BaseFragment<FragmentSocialBinding, SocialViewModel>  {

    FragmentSocialBinding mFragmentSocialBinding;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    SocialAdapter adapter;
    @Inject
    ChannelsViewModel channelsViewModel;
    @Inject
    SocialViewModel socialViewModel;

    public static SocialFragment newInstance() {
        Bundle args = new Bundle();
        SocialFragment fragment = new SocialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_social;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Observer<String> dataObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String status) {
                socialViewModel.getDataFromLocal();
                adapter.notifyDataSetChanged();
            }
        };
        channelsViewModel.getData().observe(this, dataObserver);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentSocialBinding = getViewDataBinding();
        setUp();
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }


    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentSocialBinding.socialRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentSocialBinding.socialRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentSocialBinding.socialRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
