package com.example.taskapplication.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body {
    @Expose
    @SerializedName("channels")
    private List<GeneralModel> channels = null;
    @Expose
    @SerializedName("socials")
    private List<GeneralModel> socials = null;

    public List<GeneralModel> getChannels() {
        return channels;
    }

    public void setChannels(List<GeneralModel> channels) {
        this.channels = channels;
    }

    public List<GeneralModel> getSocials() {
        return socials;
    }

    public void setSocials(List<GeneralModel> socials) {
        this.socials = socials;
    }
}
