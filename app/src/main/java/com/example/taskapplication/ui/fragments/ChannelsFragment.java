package com.example.taskapplication.ui.fragments;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.taskapplication.BR;
import com.example.taskapplication.R;
import com.example.taskapplication.databinding.FragmentChannelsBinding;
import com.example.taskapplication.di.components.FragmentComponent;
import com.example.taskapplication.ui.adapters.ChannelsAdapter;
import com.example.taskapplication.viewModels.ChannelsViewModel;

import javax.inject.Inject;

public class ChannelsFragment extends BaseFragment<FragmentChannelsBinding, ChannelsViewModel> {

    FragmentChannelsBinding mFragmentChannelBinding;
    @Inject
    ChannelsAdapter adapter;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    ChannelsViewModel channelsViewModel;

    public static ChannelsFragment newInstance() {
        Bundle args = new Bundle();
        ChannelsFragment fragment = new ChannelsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_channels;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        channelsViewModel.fetchData();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentChannelBinding = getViewDataBinding();
        setUp();
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }


    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentChannelBinding.channelsRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentChannelBinding.channelsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentChannelBinding.channelsRecyclerView.setAdapter(adapter);
    }
}
