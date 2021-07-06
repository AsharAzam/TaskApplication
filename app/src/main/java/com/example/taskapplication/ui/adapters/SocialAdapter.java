package com.example.taskapplication.ui.adapters;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapplication.TaskApplication;
import com.example.taskapplication.data.network.models.SocialModel;
import com.example.taskapplication.databinding.ItemEmptyLayoutBinding;
import com.example.taskapplication.databinding.ItemSocialViewBinding;
import com.example.taskapplication.ui.viewHolders.BaseViewHolder;
import com.example.taskapplication.utils.AppLogger;
import com.example.taskapplication.viewModels.EmptyItemViewModel;
import com.example.taskapplication.viewModels.SocialItemsViewModel;
import java.util.List;

public class SocialAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<SocialModel> mSocialResponseList;
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;


    public SocialAdapter(List<SocialModel> channelResponseList) {
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
                ItemSocialViewBinding viewBinding = ItemSocialViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new SocialAdapter.SocialViewHolder(viewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemEmptyLayoutBinding emptyViewBinding = ItemEmptyLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new SocialAdapter.EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<SocialModel> socialModelsList) {
        mSocialResponseList.addAll(socialModelsList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mSocialResponseList.clear();
    }

    public class SocialViewHolder extends BaseViewHolder implements SocialItemsViewModel.SocialItemViewModelListener {

        private ItemSocialViewBinding mBinding;

        private SocialItemsViewModel socialItemsViewModel;

        public SocialViewHolder(ItemSocialViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final SocialModel data = mSocialResponseList.get(position);
            socialItemsViewModel = new SocialItemsViewModel(data, this);
            mBinding.setViewModel(socialItemsViewModel);
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(SocialModel model) {
            if (model != null) {
                try {
                    PackageManager pm = TaskApplication.getAppContext().getPackageManager();
                    Intent launchIntent = pm.getLaunchIntentForPackage(model.getPackageName());
                    if (launchIntent==null){
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getUrl()));
                        TaskApplication.getAppContext().startActivity(browserIntent);
                    }else {
                        TaskApplication.getAppContext().startActivity(launchIntent);
                    }
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
