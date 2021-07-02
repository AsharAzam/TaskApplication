package com.example.taskapplication.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body {
    @Expose
    @SerializedName("channels")
    private List<ChannelModel> channels = null;
    @Expose
    @SerializedName("socials")
    private List<SocialModel> socials = null;

    public List<ChannelModel> getChannels() {
        return channels;
    }

    public void setChannels(List<ChannelModel> channels) {
        this.channels = channels;
    }

    public List<SocialModel> getSocials() {
        return socials;
    }

    public void setSocials(List<SocialModel> socials) {
        this.socials = socials;
    }
}
