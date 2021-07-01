package com.example.taskapplication.di.modules;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.taskapplication.ui.fragments.BaseFragment;
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
}
