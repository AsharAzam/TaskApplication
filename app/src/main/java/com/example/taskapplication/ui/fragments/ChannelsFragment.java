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
import com.example.taskapplication.network.models.ChannelModel;
import com.example.taskapplication.ui.adapters.ChannelsAdapter;
import com.example.taskapplication.viewModels.ChannelsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ChannelsFragment extends BaseFragment<FragmentChannelsBinding, ChannelsViewModel> {

    FragmentChannelsBinding mFragmentChannelBinding;

    @Inject
    ChannelsAdapter adapter;
    @Inject
    LinearLayoutManager mLayoutManager;

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
        List<ChannelModel> channelListLiveData;
        channelListLiveData = new ArrayList<>();
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        adapter.addItems(channelListLiveData);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentChannelBinding.channelsRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentChannelBinding.channelsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentChannelBinding.channelsRecyclerView.setAdapter(adapter);
    }
}
