package com.randomme.srombs.randomme;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by srombs on 5/11/17.
 */

public class MockRandomMeTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, MockRandomMeApplication.class.getName(), context);
    }
}
