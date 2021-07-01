package com.example.taskapplication.ui.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.taskapplication.databinding.ItemChannelsViewBinding;
import com.example.taskapplication.network.models.ChannelModel;
import com.example.taskapplication.ui.viewHolders.BaseViewHolder;
import com.example.taskapplication.utils.AppLogger;
import com.example.taskapplication.viewModels.ChannelItemsViewModel;
import java.util.List;

public class ChannelsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ChannelModel> mChannelResponseList;

    public ChannelsAdapter(List<ChannelModel> channelResponseList) {
        this.mChannelResponseList = channelResponseList;
    }

    @Override
    public int getItemCount() {
        if (mChannelResponseList != null && mChannelResponseList.size() > 0) {
            return mChannelResponseList.size();
        } else {
            return 1;
        }
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemChannelsViewBinding viewBinding = ItemChannelsViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ChannelViewHolder(viewBinding);
    }

    public void addItems(List<ChannelModel> blogList) {
        mChannelResponseList.addAll(blogList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mChannelResponseList.clear();
    }

    public class ChannelViewHolder extends BaseViewHolder implements ChannelItemsViewModel.ChannelItemViewModelListener {

        private ItemChannelsViewBinding mBinding;

        private ChannelItemsViewModel channelItemsViewModel;

        public ChannelViewHolder(ItemChannelsViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final ChannelModel data = mChannelResponseList.get(position);
            channelItemsViewModel = new ChannelItemsViewModel(data, this);
            mBinding.setViewModel(channelItemsViewModel);
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(ChannelModel model) {
            if (model != null) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("url error");
                }
            }
        }
    }

}
