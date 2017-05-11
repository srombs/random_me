package com.randomme.srombs.randomme.api;

import com.randomme.srombs.randomme.model.User;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by srombs on 5/11/17.
 */

public interface Api {

    @GET("/")
    Observable<List<User>> getUsers();
}
