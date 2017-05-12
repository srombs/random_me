package com.randomme.srombs.randomme;

import android.app.Application;

import com.randomme.srombs.randomme.dagger.ApiModule;
import com.randomme.srombs.randomme.dagger.DaggerAppComponent;
import com.randomme.srombs.randomme.dagger.DemoComponent;
import com.randomme.srombs.randomme.dagger.PresenterModule;

import timber.log.Timber;

/**
 * Created by srombs on 5/11/17.
 */

public class RandomMeApplication extends Application {

    DemoComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = createComponent();

        Timber.plant(new Timber.DebugTree());
    }

    public DemoComponent getComponent() {
        return component;
    }

    public DemoComponent createComponent() {
        return DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .presenterModule(new PresenterModule())
                .build();
    }
}
