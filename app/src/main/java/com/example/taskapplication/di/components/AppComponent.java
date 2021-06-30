package com.example.taskapplication.di.components;

import android.app.Application;
import com.example.taskapplication.TaskApplication;
import com.example.taskapplication.di.modules.AppModule;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(TaskApplication app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();

    }
}
