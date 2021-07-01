package com.example.taskapplication.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapplication.network.models.ChannelModel;
import com.example.taskapplication.ui.adapters.ChannelsAdapter;

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
}
