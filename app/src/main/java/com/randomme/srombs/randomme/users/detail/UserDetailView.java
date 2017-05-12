package com.randomme.srombs.randomme.users.detail;

import com.randomme.srombs.randomme.model.User;
import com.randomme.srombs.randomme.presenter.BaseView;

/**
 * Created by srombs on 5/11/17.
 */

public interface UserDetailView extends BaseView {

    void showUserDetail(User user);
}
