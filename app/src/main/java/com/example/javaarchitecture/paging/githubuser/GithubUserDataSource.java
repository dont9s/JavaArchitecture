package com.example.javaarchitecture.paging.githubuser;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.example.javaarchitecture.data.GithubUser;
import com.example.javaarchitecture.database.GithubUserDao;

import java.util.List;

import javax.inject.Inject;

public class GithubUserDataSource extends PositionalDataSource<GithubUser> {


    private final GithubUserDao userDao;

    @Inject
    public GithubUserDataSource(GithubUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<GithubUser> callback) {
        List<GithubUser> githubUsers = userDao.getAllUsersList();
        callback.onResult(githubUsers, 0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<GithubUser> callback) {

    }
}
