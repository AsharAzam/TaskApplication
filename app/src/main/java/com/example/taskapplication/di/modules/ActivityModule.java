package com.example.taskapplication.di.modules;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;
import com.example.taskapplication.data.network.DataManager;
import com.example.taskapplication.ui.activities.BaseActivity;
import com.example.taskapplication.ui.adapters.FeedPagerAdapter;
import com.example.taskapplication.utils.SchedulerProvider;
import com.example.taskapplication.viewModels.MainViewModel;
import com.example.taskapplication.viewModels.ViewModelProviderFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private BaseActivity<?, ?> activity;
    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter() {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    MainViewModel provideMainViewModel(DataManager manager,SchedulerProvider schedulerProvider) {
        Supplier<MainViewModel> supplier = () -> new MainViewModel(manager,schedulerProvider);
        ViewModelProviderFactory<MainViewModel> factory = new ViewModelProviderFactory<>(MainViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(MainViewModel.class);
    }

}
