package com.example.taskapplication.data.network;

import com.example.taskapplication.data.network.models.ApiResponse;
import io.reactivex.Single;

public interface ApiHelper {
    Single<ApiResponse> getData();
}
