package com.example.javaarchitecture.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaarchitecture.R;
import com.example.javaarchitecture.data.GithubUser;
import com.example.javaarchitecture.databinding.ItemGithubUserBinding;
import com.squareup.picasso.Picasso;

public class GithubUserListAdapter extends PagedListAdapter<GithubUser, GithubUserListAdapter.GithubUserViewHolder> {
    public  GithubUserListAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public GithubUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGithubUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_github_user, null, false);

        GithubUserViewHolder viewHolder = new GithubUserViewHolder(binding);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull GithubUserViewHolder holder,
                                 int position) {
        GithubUser githubUser = getItem(position);
        if (githubUser != null) {
            holder.bindTo(githubUser);
        } else {
            // Null defines a placeholder item - PagedListAdapter automatically
            // invalidates this row when the actual object is loaded from the
            // database.
            holder.clear();
        }
    }

    static class GithubUserViewHolder extends RecyclerView.ViewHolder {

        ItemGithubUserBinding binding;

        public GithubUserViewHolder(ItemGithubUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(GithubUser githubUser) {
            Picasso.get().load(githubUser.getAvatar_url()).into(binding.ivAvatar);
            binding.setGithubUser(githubUser);
        }

        public void clear() {

        }
    }

    private static DiffUtil.ItemCallback<GithubUser> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<GithubUser>() {
                // Concert details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(GithubUser oldUser, GithubUser newUser) {
                    return oldUser.getId() == newUser.getId();
                }

                @Override
                public boolean areContentsTheSame(GithubUser oldUser,
                                                  GithubUser newUser) {
                    return oldUser.equals(newUser);
                }
            };

}
