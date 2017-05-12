package com.randomme.srombs.randomme.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by srombs on 5/11/17.
 */
@Parcel
public class Name {


    @SerializedName("title")
    private String title;
    @SerializedName("first")
    private String first;
    @SerializedName("last")
    private String last;

    public Name() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
