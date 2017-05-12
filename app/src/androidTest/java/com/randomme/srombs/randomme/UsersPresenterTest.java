package com.randomme.srombs.randomme;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.randomme.srombs.randomme.api.Api;
import com.randomme.srombs.randomme.dagger.TestingComponent;
import com.randomme.srombs.randomme.model.Location;
import com.randomme.srombs.randomme.model.LoginInfo;
import com.randomme.srombs.randomme.model.Name;
import com.randomme.srombs.randomme.model.PictureUrls;
import com.randomme.srombs.randomme.model.Results;
import com.randomme.srombs.randomme.model.User;
import com.randomme.srombs.randomme.users.UsersPresenter;
import com.randomme.srombs.randomme.users.UsersView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

import static org.mockito.Mockito.*;

/**
 * Created by srombs on 5/11/17.
 */
@RunWith(AndroidJUnit4.class)
public class UsersPresenterTest {

    @Inject
    Api api;

    UsersView mockView;
    UsersPresenter presenter;

    @Rule
    public RxSchedulersOverrideRule overrideRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() throws Exception {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();

        RandomMeApplication app = (RandomMeApplication) instrumentation.getTargetContext().getApplicationContext();
        TestingComponent component = (TestingComponent) app.getComponent();
        component.inject(this);

        //setup the presenter
        presenter = new UsersPresenter(api);
        mockView = mock(UsersView.class);
        presenter.onAttach(mockView);

    }

    @Test
    public void shouldShowUsers() {

        when(api.getUsers()).thenReturn(Observable.just(setupListResults()));

        presenter.loadUsers();

        verify(mockView).showLoadingIndicator();
        verify(mockView).showUsers(Matchers.anyListOf(User.class));
        verify(mockView).hideLoadingIndicator();

        verifyNoMoreInteractions(mockView);

    }

    @Test
    public void showShowErrorWhenLoadingUsers() {
        when(api.getUsers()).thenReturn(Observable.error(null));

        presenter.loadUsers();

        verify(mockView).showLoadingIndicator();
        verify(mockView).showLoadingError();
        verify(mockView).hideLoadingIndicator();

        verifyNoMoreInteractions(mockView);
    }

    private Results setupListResults() {
        Results results = new Results();
        results.setUsers(setupUserList());
        return results;
    }

    private List<User> setupUserList() {

        List<User> users = new ArrayList<>();
        users.add(setupUser1());

        return users;
    }

    private User setupUser1() {
        User user1 = new User();

        Name name = new Name();
        name.setFirst("FirstTest");
        name.setLast("LastTest");
        name.setTitle("Mr. Test");
        user1.setName(name);

        PictureUrls urls = new PictureUrls();
        urls.setLargeUrl("fake");
        urls.setMediumUrl("fakeMedium");
        urls.setThumbnailUrl("fakeThumb");

        Location location = new Location();
        location.setCity("fakeCity");
        location.setState("fakeState");
        location.setStreet("fakeStreet");

        LoginInfo login = new LoginInfo();

        user1.setName(name);
        user1.setBirthdate("fakeBirthday");
        user1.setLocation(location);
        user1.setLogin(login);
        user1.setPicture(urls);

        return user1;
    }

}
