package com.example.taskapplication.di.components;

import com.example.taskapplication.di.modules.ActivityModule;
import com.example.taskapplication.di.scope.ActivityScope;
import com.example.taskapplication.ui.activities.MainActivity;
import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

}
