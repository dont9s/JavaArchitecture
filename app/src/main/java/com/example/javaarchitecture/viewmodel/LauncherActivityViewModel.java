package com.example.javaarchitecture.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.javaarchitecture.data.GithubUser;
import com.example.javaarchitecture.repository.GithubRepository;


public class LauncherActivityViewModel extends ViewModel {

    public static final int PAGE_SIZE = 10;
    private final GithubRepository repository;


    private LiveData<PagedList<GithubUser>> githubUsers = new MediatorLiveData<>();


    @ViewModelInject
    public LauncherActivityViewModel(GithubRepository repository, @Assisted SavedStateHandle savedStateHandle) {

        this.repository = repository;

        DataSource.Factory<Integer, GithubUser> factory = repository.loadGithubUsers();
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .build();

        githubUsers = new LivePagedListBuilder(factory, config).build();
    }

    public LiveData<PagedList<GithubUser>> getGithubUsers() {
        return githubUsers;
    }
}
