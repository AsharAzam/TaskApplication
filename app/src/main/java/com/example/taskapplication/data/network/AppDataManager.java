package com.example.taskapplication.data.network;

import android.content.Context;
import com.example.taskapplication.data.local.db.DbHelper;
import com.example.taskapplication.data.network.models.ApiResponse;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;
import com.google.gson.Gson;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager{

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final Gson mGson;

    private final DbHelper mDbHelper;

    @Override
    public Single<ApiResponse> getData() {
        return  mApiHelper.getData();
    }

    @Inject
    public AppDataManager(Context context, ApiHelper apiHelper, Gson gson, DbHelper dbHelper) {
        mContext = context;
        mApiHelper = apiHelper;
        mGson = gson;
        mDbHelper = dbHelper;

    }

    @Override
    public Single<List<ChannelModel>> getChannelData() {
        return mDbHelper.getAllChannels();
    }

    @Override
    public Observable<List<SocialModel>> getSocialData() {
        return mDbHelper.getAllSocials();
    }

    @Override
    public Single<List<ChannelModel>> getAllChannels() {
        return mDbHelper.getAllChannels();
    }

    @Override
    public Observable<List<SocialModel>> getAllSocials() {
        return mDbHelper.getAllSocials();
    }

    @Override
    public Observable<Boolean> saveChannelList(List<ChannelModel> channelList) {
        return mDbHelper.saveChannelList(channelList);
    }

    @Override
    public Observable<Boolean> saveSocialList(List<SocialModel> socialList) {
        return mDbHelper.saveSocialList(socialList);
    }
}
