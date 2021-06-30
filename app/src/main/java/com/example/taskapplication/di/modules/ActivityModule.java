package com.example.taskapplication.di.modules;

import com.example.taskapplication.ui.activities.BaseActivity;
import dagger.Module;

@Module
public class ActivityModule {
    private BaseActivity<?, ?> activity;
    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }
}
