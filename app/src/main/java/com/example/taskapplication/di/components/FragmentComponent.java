package com.example.taskapplication.di.components;

import com.example.taskapplication.di.modules.FragmentModule;
import com.example.taskapplication.di.scope.FragmentScope;
import com.example.taskapplication.ui.fragments.ChannelsFragment;
import com.example.taskapplication.ui.fragments.SocialFragment;
import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(SocialFragment fragment);
    void inject(ChannelsFragment fragment);
}
