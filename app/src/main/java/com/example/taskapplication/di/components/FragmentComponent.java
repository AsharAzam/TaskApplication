package com.example.taskapplication.di.components;

import com.example.taskapplication.di.modules.FragmentModule;
import com.example.taskapplication.di.scope.FragmentScope;
import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
}
