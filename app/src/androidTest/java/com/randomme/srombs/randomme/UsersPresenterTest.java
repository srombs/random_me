package com.randomme.srombs.randomme;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.randomme.srombs.randomme.api.Api;
import com.randomme.srombs.randomme.dagger.TestingComponent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by srombs on 5/11/17.
 */
@RunWith(AndroidJUnit4.class)
public class UsersPresenterTest {

    @Inject
    Api api;

    @Rule
    public RxSchedulersOverrideRule overrideRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() throws Exception {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();

        RandomMeApplication app = (RandomMeApplication) instrumentation.getTargetContext().getApplicationContext();
        TestingComponent component = (TestingComponent) app.getComponent();
        component.inject(this);

    }
}
