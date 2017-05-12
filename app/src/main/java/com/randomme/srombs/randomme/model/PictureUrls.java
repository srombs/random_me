package com.randomme.srombs.randomme.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by srombs on 5/11/17.
 */
@Parcel
public class PictureUrls {

    public PictureUrls() {
    }

    @SerializedName("large")
    private String largeUrl;
    @SerializedName("medium")
    private String mediumUrl;
    @SerializedName("thumbnail")
    private String thumbnailUrl;

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
