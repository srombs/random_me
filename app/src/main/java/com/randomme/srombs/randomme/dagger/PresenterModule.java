package com.randomme.srombs.randomme.dagger;

import com.randomme.srombs.randomme.users.UsersPresenter;
import com.randomme.srombs.randomme.api.Api;

import dagger.Module;
import dagger.Provides;

/**
 * Created by srombs on 5/11/17.
 */
@Module
public class PresenterModule {

    @Provides
    public UsersPresenter providesUsersPresenter(Api api) {
        return new UsersPresenter(api);
    }
}
