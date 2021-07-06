package com.example.taskapplication.viewModels;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.data.network.models.Body;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;
import com.example.taskapplication.utils.SchedulerProvider;
import java.util.List;

public class ApiViewModel extends BaseViewModel {

    public static final String TAG = ApiViewModel.class.getSimpleName();
    private final MutableLiveData<List<ChannelModel>> channelListLiveData;
    public static MutableLiveData<String> data;
    private static boolean isNetworkCalled=false;


    public static MutableLiveData<String> getData() {
        if (data == null) {
            data = new MutableLiveData<String>();
        }
        return data;
    }


    public ApiViewModel(DataManager manager, SchedulerProvider schedulerProvide) {
        super(manager, schedulerProvide);
        channelListLiveData = new MutableLiveData<>();
        //if database is empty make server call to get data and store else load data form local storage
        getDataFromLocal();
    }

    private void getDataFromLocal() {
        getCompositeDisposable().add(
                getDataManager().getChannelData()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(channelList -> {
                            if (channelList != null && channelList.size() > 0) {
                                Log.d(TAG, "getData: " + channelList.size());
                                channelListLiveData.setValue(channelList);
                            } else {
                                getDataFromServer();
                            }
                        }, throwable -> {
                            Log.d(TAG, "getData: " + throwable);
                        }));


    }


    public void getDataFromServer() {
        if (!isNetworkCalled) {
            isNetworkCalled=true;
            setIsLoading(true);
            getCompositeDisposable().add(getDataManager()
                    .getData()
                    .doOnSuccess(response -> saveData(response.getBody()))
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(apiResponse -> {
                        channelListLiveData.setValue(apiResponse.getBody().getChannels());
                        setIsLoading(false);
                    }, throwable -> {
                        setIsLoading(false);
                    }));
        }
    }

    private void saveData(Body body) {
        saveDataForChannels(body.getChannels());
        saveDataForSocials(body.getSocials());
    }

    private void saveDataForSocials(List<SocialModel> list) {
        getCompositeDisposable().add(getDataManager()
                .saveSocialList(list)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    getData().setValue("Data Comes");
                    Log.d(TAG, "getData: " + list.size());
                }, throwable -> {
                    Log.d(TAG, "getData: " + list.size());

                }));
    }

    private void saveDataForChannels(List<ChannelModel> list) {
        getCompositeDisposable().add(getDataManager()
                .saveChannelList(list)
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
