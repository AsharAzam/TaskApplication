package com.example.taskapplication.data.local.db;

import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface DbHelper {

    Single<List<ChannelModel>> getAllChannels();

    Observable<List<SocialModel>> getAllSocials();

    Observable<Boolean> saveChannelList(List<ChannelModel> channelList);

    Observable<Boolean> saveSocialList(List<SocialModel> socialList);

}
