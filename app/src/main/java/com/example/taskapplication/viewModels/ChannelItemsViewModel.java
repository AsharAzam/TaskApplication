package com.example.taskapplication.viewModels;

import androidx.databinding.ObservableField;
import com.example.taskapplication.data.network.models.GeneralModel;

public class ChannelItemsViewModel {

    public final ObservableField<String> name;

    public final ObservableField<String> url;

    public final ObservableField<String> coverImageUrl;

    public final ObservableField<String> packageName;

    public final ChannelItemViewModelListener mListener;

    private final GeneralModel mModel;

    public ChannelItemsViewModel(GeneralModel model, ChannelItemViewModelListener listener) {
        this.mModel = model;
        this.mListener = listener;
        name = new ObservableField<>(mModel.getName());
        url = new ObservableField<>(mModel.getUrl());
        coverImageUrl = new ObservableField<>(mModel.getCoverImgUrl());
        packageName = new ObservableField<>(mModel.getPackageName());
    }

    public void onItemClick() {
        mListener.onItemClick(mModel);
    }

    public interface ChannelItemViewModelListener {

        void onItemClick(GeneralModel model);
    }
}
