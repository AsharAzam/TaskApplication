package com.example.taskapplication.ui.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.taskapplication.data.network.models.GeneralModel;
import com.example.taskapplication.data.network.models.SocialModel;
import com.example.taskapplication.databinding.ItemChannelsViewBinding;
import com.example.taskapplication.databinding.ItemEmptyLayoutBinding;
import com.example.taskapplication.ui.viewHolders.BaseViewHolder;
import com.example.taskapplication.utils.AppLogger;
import com.example.taskapplication.viewModels.ChannelItemsViewModel;
import com.example.taskapplication.viewModels.EmptyItemViewModel;
import java.util.List;

public class SocialAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<GeneralModel> mSocialResponseList;
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;


    public SocialAdapter(List<GeneralModel> channelResponseList) {
        this.mSocialResponseList = channelResponseList;
    }

    @Override
    public int getItemCount() {
        if (mSocialResponseList != null && mSocialResponseList.size() > 0) {
            return mSocialResponseList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mSocialResponseList != null && !mSocialResponseList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemChannelsViewBinding viewBinding = ItemChannelsViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new SocialAdapter.SocialViewHolder(viewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemEmptyLayoutBinding emptyViewBinding = ItemEmptyLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new SocialAdapter.EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<GeneralModel> socialModelsList) {
        mSocialResponseList.addAll(socialModelsList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mSocialResponseList.clear();
    }

    public class SocialViewHolder extends BaseViewHolder implements ChannelItemsViewModel.ChannelItemViewModelListener {

        private ItemChannelsViewBinding mBinding;

        private ChannelItemsViewModel channelItemsViewModel;

        public SocialViewHolder(ItemChannelsViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final GeneralModel data = mSocialResponseList.get(position);
            channelItemsViewModel = new ChannelItemsViewModel(data, this);
            mBinding.setViewModel(channelItemsViewModel);
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(GeneralModel model) {
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

    public class EmptyViewHolder extends BaseViewHolder {

        private ItemEmptyLayoutBinding mBinding;

        public EmptyViewHolder(ItemEmptyLayoutBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            EmptyItemViewModel emptyItemViewModel = new EmptyItemViewModel();
            mBinding.setViewModel(emptyItemViewModel);
        }
    }
}
