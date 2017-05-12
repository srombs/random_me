package com.randomme.srombs.randomme.users;

import com.randomme.srombs.randomme.model.User;
import com.randomme.srombs.randomme.presenter.BaseView;

import java.util.List;

/**
 * Created by srombs on 5/11/17.
 */

public interface UsersView extends BaseView {

    void showUsers(List<User> users);
    void showLoadingError();
    void showNoUsers();
    void showLoadingIndicator();
    void hideLoadingIndicator();
}
