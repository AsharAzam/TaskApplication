package com.example.taskapplication.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskapplication.data.local.db.AppDbHelper;
import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;
import com.example.taskapplication.utils.SchedulerProvider;
import java.util.List;

import javax.inject.Inject;

public class ChannelsViewModel extends BaseViewModel {

    public static final String TAG=ChannelsViewModel.class.getSimpleName();
    private final MutableLiveData<List<ChannelModel>> channelListLiveData;
    @Inject
    AppDbHelper dbHelper;

    public ChannelsViewModel(DataManager manager,SchedulerProvider schedulerProvide) {
        super(manager,schedulerProvide);
        channelListLiveData = new MutableLiveData<>();
        //if database is empty make server call to get data and store else load data form local storage
        getDataFromLocal();
    }

    private void getDataFromLocal() {
        getCompositeDisposable().add(getDataManager()
                .getChannelData()
                .doOnNext(list -> Log.d(TAG, "getData: " + list.size()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(channelList -> {
                    if (channelList != null && channelList.size()>0) {
                        Log.d(TAG, "getData: " + channelList.size());
                        channelListLiveData.setValue(channelList);
                    }else {
                        getDataFromServer();
                    }
                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
                }));
    }

    public void getDataFromServer() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getData()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(apiResponse -> {
                    if (apiResponse.getHeader().getCode()==1) {
                        channelListLiveData.setValue(apiResponse.getBody().getChannels());
                        saveDataForChannels(apiResponse.getBody().getChannels());
                        saveDataForSocials(apiResponse.getBody().getSocials());

                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));
    }

    private void saveDataForSocials(List<SocialModel> list) {
        getCompositeDisposable().add(getDataManager()
                .saveSocialData(list)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    Log.d(TAG, "getData: " + list.size());
                }, throwable -> {
                    Log.d(TAG, "getData: " + list.size());

                }));
    }

    private void saveDataForChannels(List<ChannelModel> list) {
        getCompositeDisposable().add(getDataManager()
                .saveChannelData(list)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    Log.d(TAG, "getData: " + list.size());
                }, throwable -> {
                    Log.d(TAG, "getData: " + list.size());

                }));
    }

    public LiveData<List<ChannelModel>> getChannelListLiveData() {
        return channelListLiveData;
    }

}
