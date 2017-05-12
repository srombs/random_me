package com.randomme.srombs.randomme.users.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.randomme.srombs.randomme.R;
import com.randomme.srombs.randomme.model.User;
import com.randomme.srombs.randomme.util.BundleKey;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity {

    @Inject UserDetailPresenter presenter;

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.address)
    TextView address;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            user = Parcels.unwrap(getIntent().getExtras().getParcelable(BundleKey.USER));
        } else {
            user = new User();
        }

        showUserDetails(user);
    }

    private void showUserDetails(User user) {
        String first = user.getName().getFirst();
        String last = user.getName().getLast();
        String title = user.getName().getTitle();

        String displayName = getString(R.string.name, title, first, last);
        name.setText(displayName);

        String street = user.getLocation().getStreet();
        String city = user.getLocation().getCity();
        String state = user.getLocation().getState();

        String displayAddress = getString(R.string.name, street, city, state);

        address.setText(displayAddress);
    }
}
