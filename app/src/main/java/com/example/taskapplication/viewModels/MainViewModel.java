package com.example.taskapplication.viewModels;

import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.utils.SchedulerProvider;

public class MainViewModel extends BaseViewModel {
    public MainViewModel(DataManager manager,SchedulerProvider schedulerProvider) {
        super(manager,schedulerProvider);
    }
}
