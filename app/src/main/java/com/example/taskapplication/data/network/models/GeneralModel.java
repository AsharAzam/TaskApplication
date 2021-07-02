package com.example.taskapplication.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralModel {
    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("url")
    private String url;

    @Expose
    @SerializedName("icon_url")
    private String coverImgUrl;

    @Expose
    @SerializedName("package_name_android")
    private String packageName;

    public GeneralModel(String name, String url, String coverImgUrl, String packageName) {
        this.name = name;
        this.url = url;
        this.coverImgUrl = coverImgUrl;
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}