package com.example.taskapplication.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;
import com.example.taskapplication.utils.SchedulerProvider;
import java.util.List;

public class ChannelsViewModel extends BaseViewModel {

    private final MutableLiveData<List<ChannelModel>> channelListLiveData;

    public ChannelsViewModel(DataManager manager,SchedulerProvider schedulerProvider) {
        super(manager,schedulerProvider);
        channelListLiveData = new MutableLiveData<>();
        fetchData();
    }

    public void fetchData() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getData()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(apiResponse -> {
                    if (apiResponse.getHeader().getCode()==1) {
                        channelListLiveData.setValue(apiResponse.getBody().getChannels());
                        setSocialListData(apiResponse.getBody().getChannels());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));
    }

    public LiveData<List<ChannelModel>> getChannelListLiveData() {
        return channelListLiveData;
    }

}
