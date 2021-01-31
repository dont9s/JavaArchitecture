package com.example.javaarchitecture.paging.githubuser;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.javaarchitecture.data.GithubUser;
import com.example.javaarchitecture.database.GithubUserDao;

import javax.inject.Inject;

public class GithubUserDataSourceFactory extends DataSource.Factory<Integer, GithubUser> {

    private final MutableLiveData<GithubUserDataSource> userDataSourceLiveData;
    private final GithubUserDao githubUserDao;

    @Inject
    public GithubUserDataSourceFactory(GithubUserDao githubUserDao) {
        this.githubUserDao = githubUserDao;
        this.userDataSourceLiveData = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource<Integer, GithubUser> create() {
        GithubUserDataSource githubUserDataSource = new GithubUserDataSource(githubUserDao);

        userDataSourceLiveData.postValue(githubUserDataSource);

        return githubUserDataSource;
    }
}
