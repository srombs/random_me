package com.randomme.srombs.randomme.dagger;

import com.randomme.srombs.randomme.UsersPresenterTest;
import com.randomme.srombs.randomme.dagger.DemoComponent;
import com.randomme.srombs.randomme.dagger.MockApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by srombs on 5/11/17.
 */
@Singleton
@Component(modules = {MockApiModule.class})
public interface TestingComponent extends DemoComponent {
    void inject(UsersPresenterTest target);
}
