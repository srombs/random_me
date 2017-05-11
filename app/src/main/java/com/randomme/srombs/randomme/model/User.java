package com.randomme.srombs.randomme.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by srombs on 5/11/17.
 */

public class User {

    @SerializedName("name")
    Name name;
    @SerializedName("location")
    Location location;
    @SerializedName("login")
    LoginInfo login;
    @SerializedName("dob")
    Birthdate birthdate;
    @SerializedName("picture")
    PictureUrls picture;
}
