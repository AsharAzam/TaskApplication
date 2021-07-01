package com.example.taskapplication.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.taskapplication.network.models.ChannelModel;
import com.example.taskapplication.utils.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

public class ChannelsViewModel extends BaseViewModel {

    private List<ChannelModel> channelListLiveData;

    public ChannelsViewModel(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
        channelListLiveData = new ArrayList<>();
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));
        channelListLiveData.add(new ChannelModel("Test","","https://i.imgur.com/3McFm3K_d.webp?maxwidth=640&shape=thumb&fidelity=medium","Test"));


    }

    public List<ChannelModel> getChannelListLiveData() {
        return channelListLiveData;
    }
}
