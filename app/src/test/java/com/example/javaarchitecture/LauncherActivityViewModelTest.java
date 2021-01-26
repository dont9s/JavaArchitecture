package com.example.javaarchitecture;

import androidx.lifecycle.SavedStateHandle;

import com.example.javaarchitecture.database.GithubUserDao;
import com.example.javaarchitecture.repository.GithubRepository;
import com.example.javaarchitecture.retrofit.GithubUserApi;
import com.example.javaarchitecture.viewmodel.LauncherActivityViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mock;

import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LauncherActivityViewModelTest {

    private LauncherActivityViewModel viewModel;

    private GithubRepository repository;
    @Mock
    GithubUserApi userApi;
    @Mock
    GithubUserDao githubUserDao;

    Executor executor;
    @Mock
    SavedStateHandle savedStateHandle;

    @Before
    public void setUp() {
        executor = Executors.newSingleThreadExecutor();
        repository = new GithubRepository(userApi, githubUserDao, executor);

        viewModel = new LauncherActivityViewModel(repository, savedStateHandle);
    }

    @Test
    public void assertPageSizeIsTen() {
        Assert.assertEquals(10, LauncherActivityViewModel.PAGE_SIZE);
    }


    @Test
    public void assertGetGithubUsersSaveDataInDatabase() {
        repository.loadGithubUsers();

        verify(githubUserDao).insertAll(new ArrayList<>());
    }


}
