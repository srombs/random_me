package com.randomme.srombs.randomme.dagger;

import com.randomme.srombs.randomme.users.UsersActivity;
import com.randomme.srombs.randomme.users.UsersPresenter;

/**
 * Created by srombs on 5/11/17.
 */

public interface DemoComponent {
    void inject(UsersActivity target);
    void inject(UsersPresenter target);
}
