package com.randomme.srombs.randomme.users;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.randomme.srombs.randomme.R;
import com.randomme.srombs.randomme.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by srombs on 5/11/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private List<User> users;
    private Context context;

    public UsersAdapter(Context context) {
        users = new ArrayList<>();
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_row, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        String first = users.get(position).getName().getFirst();
        String last = users.get(position).getName().getLast();
        String title = users.get(position).getName().getTitle();

        String name = context.getString(R.string.name, title, first, last);
        holder.name.setText(name);

        String pictureUrl = users.get(position).getPicture().getLargeUrl();

        Picasso.with(context)
                .load(pictureUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users.clear();
        this.users = users;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.user_name)
        TextView name;
        @BindView(R.id.user_avatar)
        ImageView avatar;

        public UserViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
