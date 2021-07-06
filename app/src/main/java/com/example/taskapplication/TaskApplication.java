package com.example.taskapplication;

import android.app.Application;
import android.content.Context;
import com.example.taskapplication.di.components.AppComponent;
import com.example.taskapplication.di.components.DaggerAppComponent;
import com.example.taskapplication.utils.AppLogger;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import javax.inject.Inject;
import io.github.inflationx.calligraphy3.CalligraphyConfig;

public class TaskApplication extends Application {
    public AppComponent appComponent;
    private static Context context;
    @Inject
    CalligraphyConfig mCalligraphyConfig;
    @Override
    public void onCreate() {
        super.onCreate();
        TaskApplication.context = getApplicationContext();
        Fresco.initialize(this);
        Stetho.initializeWithDefaults(this);
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);

        AppLogger.init();
        //CalligraphyConfig.initDefault(mCalligraphyConfig);

    }
    public static Context getAppContext() {
        return TaskApplication.context;
    }
}
