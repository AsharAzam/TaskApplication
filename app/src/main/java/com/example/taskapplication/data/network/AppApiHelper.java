package com.example.taskapplication.data.network;

import com.example.taskapplication.data.network.models.ApiResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {
    }
    @Override
    public Single<ApiResponse> getData() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_DATA)
                .build()
                .getObjectSingle(ApiResponse.class);
    }
}
