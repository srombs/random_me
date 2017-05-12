package com.randomme.srombs.randomme.users;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.randomme.srombs.randomme.api.Api;
import com.randomme.srombs.randomme.model.User;
import com.randomme.srombs.randomme.presenter.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by srombs on 5/11/17.
 */

public class UsersPresenter extends BasePresenter<UsersView> {

    private Api api;
    private UsersView view;

    Subscription loadUsersSubscription;

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
        if(loadUsersSubscription != null && !loadUsersSubscription.isUnsubscribed()) {
            loadUsersSubscription.unsubscribe();
        }
    }

    //get a list of people from the api
    public void loadUsers() {
        view.showLoadingIndicator();

        loadUsersSubscription =
                getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    view.hideLoadingIndicator();
                    view.showUsers(users);
                }, error -> {
                    view.hideLoadingIndicator();
                    view.showLoadingError();
                });
    }

    @RxLogObservable
    private Observable<List<User>> getUsers() {
        return api.getUsers()
                .map(results -> results.getUsers());
    }
}
