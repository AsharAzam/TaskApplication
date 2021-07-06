package com.example.taskapplication.data.network;

import com.example.taskapplication.data.local.db.DbHelper;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;

import java.util.List;

import io.reactivex.Observable;

public interface DataManager extends DbHelper,ApiHelper {
    Observable<List<ChannelModel>> getChannelData();
    Observable<List<SocialModel>> getSocialData();
   /* Observable<Boolean> saveChannelData(List<ChannelModel> list);
    Observable<Boolean> saveSocialData(List<SocialModel> list);
*/

}
