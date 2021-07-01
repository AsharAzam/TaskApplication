package com.example.taskapplication;

import android.app.Application;
import com.example.taskapplication.di.components.AppComponent;
import com.example.taskapplication.di.components.DaggerAppComponent;
import com.example.taskapplication.utils.AppLogger;

import javax.inject.Inject;

import io.github.inflationx.calligraphy3.CalligraphyConfig;

public class TaskApplication extends Application {
    public AppComponent appComponent;
    @Inject
    CalligraphyConfig mCalligraphyConfig;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);

        AppLogger.init();
        //CalligraphyConfig.initDefault(mCalligraphyConfig);

    }
}
