package com.example.javaarchitecture.repository;

import androidx.paging.DataSource;

import com.example.javaarchitecture.data.GithubUser;
import com.example.javaarchitecture.database.GithubUserDao;
import com.example.javaarchitecture.retrofit.GithubUserApi;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Response;

public class GithubRepository {

    private final GithubUserApi userApi;
    private final GithubUserDao githubUserDao;
    private final Executor singleCoreExecutor;

    @Inject
    public GithubRepository(GithubUserApi userApi, GithubUserDao githubUserDao, Executor singleCoreExecutor) {
        this.userApi = userApi;
        this.githubUserDao = githubUserDao;
        this.singleCoreExecutor = singleCoreExecutor;

    }

    public DataSource.Factory<Integer, GithubUser> loadGithubUsers() {
        refreshUsers();
        // Returns a LiveData object directly from the database.
        return githubUserDao.getAllUsers();
    }


    public void refreshUsers() {
        // Runs in a background thread.
        singleCoreExecutor.execute(() -> {

            // Refreshes the data.
            Response<List<GithubUser>> response = null;
            try {
                response = userApi.getUsersAsync().execute();
                // Updates the database. The LiveData object automatically
                // refreshes, so we don't need to do anything else here.
                githubUserDao.insertAll(response.body());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }

}
