package com.example.taskapplication.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapplication.data.network.models.ChannelModel;
import com.example.taskapplication.data.network.models.SocialModel;
import com.example.taskapplication.ui.adapters.ChannelsAdapter;
import com.example.taskapplication.ui.adapters.SocialAdapter;

import java.util.List;

public class BindingUtils {
    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addChannelItems(RecyclerView recyclerView, List<ChannelModel> channelModelList) {
        ChannelsAdapter adapter = (ChannelsAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(channelModelList);
        }
    }

    @BindingAdapter({"adapter"})
    public static void addSocialItems(RecyclerView recyclerView, List<SocialModel> socialModelList) {
        SocialAdapter adapter = (SocialAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(socialModelList);
        }
    }
}
