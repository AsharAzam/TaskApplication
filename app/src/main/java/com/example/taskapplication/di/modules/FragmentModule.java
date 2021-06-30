package com.example.taskapplication.di.modules;

import com.example.taskapplication.ui.fragments.BaseFragment;
import dagger.Module;

@Module
public class FragmentModule {
    private BaseFragment<?, ?> fragment;
    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }
}
