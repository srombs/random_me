package com.randomme.srombs.randomme.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by srombs on 5/11/17.
 */

public class Results {

    @SerializedName("results")
    private List<User> users;

    public Results() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
