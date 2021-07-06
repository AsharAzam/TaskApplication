package com.example.taskapplication.viewModels;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskapplication.data.local.db.AppDbHelper;
import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.utils.SchedulerProvider;
import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class BaseViewModel<N> extends ViewModel {
    private final ObservableBoolean mIsLoading = new ObservableBoolean();
    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;
    @Inject
    SocialViewModel viewModel;

    public BaseViewModel(DataManager manager, SchedulerProvider schedulerProvider) {
        this.mDataManager=manager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
    public DataManager getDataManager() {
        return mDataManager;
    }
    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }


}
