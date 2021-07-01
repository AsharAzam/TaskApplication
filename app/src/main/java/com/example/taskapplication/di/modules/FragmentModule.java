package com.example.taskapplication.di.modules;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taskapplication.ui.adapters.ChannelsAdapter;
import com.example.taskapplication.ui.fragments.BaseFragment;
import com.example.taskapplication.utils.SchedulerProvider;
import com.example.taskapplication.viewModels.ChannelsViewModel;
import com.example.taskapplication.viewModels.SocialViewModel;
import com.example.taskapplication.viewModels.ViewModelProviderFactory;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private BaseFragment<?, ?> fragment;
    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }
    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(fragment.getActivity());
    }

    @Provides
    SocialViewModel provideSocialViewModel(SchedulerProvider schedulerProvider) {
        Supplier<SocialViewModel> supplier = () -> new SocialViewModel(schedulerProvider);
        ViewModelProviderFactory<SocialViewModel> factory = new ViewModelProviderFactory<>(SocialViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(SocialViewModel.class);
    }

    @Provides
    ChannelsViewModel provideChannelViewModel(SchedulerProvider schedulerProvider) {
        Supplier<ChannelsViewModel> supplier = () -> new ChannelsViewModel(schedulerProvider);
        ViewModelProviderFactory<ChannelsViewModel> factory = new ViewModelProviderFactory<>(ChannelsViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(ChannelsViewModel.class);
    }

    @Provides
    ChannelsAdapter provideChannelAdapter() {
        return new ChannelsAdapter(new ArrayList<>());
    }

}
