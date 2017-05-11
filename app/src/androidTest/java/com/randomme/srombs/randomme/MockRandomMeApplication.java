package com.randomme.srombs.randomme;


import com.randomme.srombs.randomme.dagger.*;

/**
 * Created by srombs on 5/11/17.
 */

public class MockRandomMeApplication extends RandomMeApplication {

    @Override
    public DemoComponent createComponent() {
        return DaggerTestingComponent.builder()
                .mockApiModule(new MockApiModule())
                .build();
    }
}
