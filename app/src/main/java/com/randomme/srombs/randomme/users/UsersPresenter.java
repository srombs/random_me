package com.randomme.srombs.randomme.users;

import com.randomme.srombs.randomme.api.Api;
import com.randomme.srombs.randomme.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * Created by srombs on 5/11/17.
 */

public class UsersPresenter extends BasePresenter<UsersView> {

    Api api;
    UsersView view;


    @Inject
    public UsersPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void onAttach(UsersView view) {
        this.view = view;
    }

    @Override
    public void onDeatch() {

    }

    public void loadUsers() {

    }
}
