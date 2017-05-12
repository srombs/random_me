package com.randomme.srombs.randomme.users.detail;

import com.randomme.srombs.randomme.presenter.BasePresenter;

/**
 * Created by srombs on 5/11/17.
 */

public class UserDetailPresenter extends BasePresenter<UserDetailView> {

    private UserDetailView view;

    @Override
    public void onAttach(UserDetailView view) {
        this.view = view;
    }

    @Override
    public void onDeatch() {

    }
}
