package com.randomme.srombs.randomme;

import com.randomme.srombs.randomme.api.Api;
import com.randomme.srombs.randomme.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * Created by srombs on 5/11/17.
 */

public class UsersPresenter extends BasePresenter<UsersView> {

    Api api;



    @Inject
    public UsersPresenter(Api api) {
        this.api = api;
    }

    @Override
    public void onAttach(UsersView view) {

    }

    @Override
    public void onDeatch() {

    }
}
