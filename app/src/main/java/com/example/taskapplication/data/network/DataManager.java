package com.example.taskapplication.data.network;

import com.example.taskapplication.data.local.db.DbHelper;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface DataManager extends DbHelper,ApiHelper {
    Single<List<ChannelModel>> getChannelData();
    Observable<List<SocialModel>> getSocialData();
}
