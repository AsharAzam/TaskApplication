package com.example.taskapplication.data.network;

import android.content.Context;
import com.example.taskapplication.data.network.models.ApiResponse;
import com.google.gson.Gson;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager{

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final Gson mGson;

    @Override
    public Single<ApiResponse> getData() {
        return  mApiHelper.getData();
    }

    @Inject
    public AppDataManager(Context context, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mApiHelper = apiHelper;
        mGson = gson;
    }
}
