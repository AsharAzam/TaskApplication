package com.example.taskapplication.data.local.db;


import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {
    private final AppDatabase mAppDatabase;


    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<ChannelModel>> getAllChannels() {
        return  mAppDatabase.channelDao().loadAll()
                .toObservable();
    }

    @Override
    public Observable<List<SocialModel>> getAllSocials() {
        return  Observable.fromCallable(new Callable<List<SocialModel>>() {
            @Override
            public List<SocialModel> call() throws Exception {
                return mAppDatabase.socialDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> saveChannelList(List<ChannelModel> channelList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.channelDao().insertAll(channelList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveSocialList(List<SocialModel> socialList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.socialDao().insertAll(socialList);
                return true;
            }
        });
    }
}
