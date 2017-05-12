package com.randomme.srombs.randomme.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by srombs on 5/11/17.
 */
@Parcel
public class User {

    @SerializedName("name")
    private Name name;
    @SerializedName("location")
    private Location location;
    @SerializedName("login")
    private LoginInfo login;
    @SerializedName("dob")
    private String birthdate;
    @SerializedName("picture")
    private PictureUrls picture;

    public User() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LoginInfo getLogin() {
        return login;
    }

    public void setLogin(LoginInfo login) {
        this.login = login;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public PictureUrls getPicture() {
        return picture;
    }

    public void setPicture(PictureUrls picture) {
        this.picture = picture;
    }
}
