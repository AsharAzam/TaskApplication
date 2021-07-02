package com.example.taskapplication.viewModels;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.utils.SchedulerProvider;
import java.lang.ref.WeakReference;
import io.reactivex.disposables.CompositeDisposable;


public class BaseViewModel<N> extends ViewModel {
    private final ObservableBoolean mIsLoading = new ObservableBoolean();
    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;
    private WeakReference<N> mNavigator;

    public BaseViewModel(DataManager manager,SchedulerProvider schedulerProvider) {
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

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}
