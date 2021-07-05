package com.example.taskapplication.di.modules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.taskapplication.R;
import com.example.taskapplication.data.local.db.AppDatabase;
import com.example.taskapplication.data.local.db.AppDbHelper;
import com.example.taskapplication.data.local.db.DbHelper;
import com.example.taskapplication.data.network.ApiHelper;
import com.example.taskapplication.data.network.AppApiHelper;
import com.example.taskapplication.data.network.AppDataManager;
import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.di.DatabaseInfo;
import com.example.taskapplication.utils.AppSchedulerProvider;
import com.example.taskapplication.utils.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }
    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "taskapplication.db";
    }


}
