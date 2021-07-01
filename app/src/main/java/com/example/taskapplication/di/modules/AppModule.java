package com.example.taskapplication.di.modules;

import android.app.Application;
import android.content.Context;
import com.example.taskapplication.R;
import com.example.taskapplication.utils.AppSchedulerProvider;
import com.example.taskapplication.utils.SchedulerProvider;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import io.github.inflationx.calligraphy3.CalligraphyConfig;

@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
