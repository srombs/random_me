package com.randomme.srombs.randomme.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by srombs on 5/11/17.
 */
@Singleton
@Component(modules = {ApiModule.class, PresenterModule.class})
public interface AppComponent extends DemoComponent {
}
