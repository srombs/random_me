package com.randomme.srombs.randomme.users;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.randomme.srombs.randomme.R;
import com.randomme.srombs.randomme.RandomMeApplication;
import com.randomme.srombs.randomme.model.User;
import com.randomme.srombs.randomme.users.detail.UserDetailActivity;
import com.randomme.srombs.randomme.util.BundleKey;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class UsersActivity extends AppCompatActivity implements UsersView {

    @BindView(R.id.user_list)
    RecyclerView recyclerView;
    private UsersAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @BindView(R.id.loading_indicator)
    ProgressBar loadingIndicator;


    @Inject UsersPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        ButterKnife.bind(this);

        ((RandomMeApplication) getApplicationContext()).getComponent().inject(this);
        presenter.onAttach(this);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UsersAdapter(this, clickListener);
        recyclerView.setAdapter(adapter);

        presenter.loadUsers();
    }

    UsersAdapter.IUserClicker clickListener = new UsersAdapter.IUserClicker() {
        @Override
        public void onUserClicked(int position) {
            Timber.d("pos: " + position);
            goToUserDetails(adapter.getUser(position));
        }
    };

    private void goToUserDetails(User user) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(BundleKey.USER, Parcels.wrap(user));
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDeatch();
    }

    @Override
    public void showUsers(List<User> users) {
        adapter.setUsers(users);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadingError() {
        Toast.makeText(this, R.string.loading_users_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoUsers() {

    }

    @Override
    public void showLoadingIndicator() {
        loadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        loadingIndicator.setVisibility(View.GONE);
    }
}
