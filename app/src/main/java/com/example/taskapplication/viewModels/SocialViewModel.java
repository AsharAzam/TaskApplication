package com.example.taskapplication.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;
import com.example.taskapplication.utils.SchedulerProvider;

import java.util.List;


public class SocialViewModel extends BaseViewModel{
    public static final String TAG=SocialViewModel.class.getSimpleName();
    private final MutableLiveData<List<SocialModel>> socialListLiveData;

    public SocialViewModel(DataManager manager,SchedulerProvider schedulerProvider) {
        super(manager,schedulerProvider);
        socialListLiveData = new MutableLiveData<>();
        getDataFromLocal();
    }

    public void getDataFromLocal() {
        getCompositeDisposable().add(getDataManager()
                .getSocialData()
                .doOnNext(list -> Log.d(TAG, "getData: " + list.size()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(socialList -> {
                    if (socialList != null && socialList.size()>0) {
                        Log.d(TAG, "getData: " + socialList.size());
                        socialListLiveData.setValue(socialList);
                    }
                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
                }));
    }

    public LiveData<List<SocialModel>> getSocialListLiveData() {
        return socialListLiveData;
    }
}
