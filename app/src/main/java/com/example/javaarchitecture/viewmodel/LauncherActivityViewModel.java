package com.example.javaarchitecture.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.javaarchitecture.data.GithubUser;
import com.example.javaarchitecture.paging.githubuser.GithubUserDataSource;
import com.example.javaarchitecture.paging.githubuser.GithubUserDataSourceFactory;
import com.example.javaarchitecture.repository.GithubRepository;
import com.example.javaarchitecture.util.NetworkState;


public class LauncherActivityViewModel extends ViewModel {

    public static final int PAGE_SIZE = 5;
    private final GithubRepository repository;
    private final GithubUserDataSourceFactory dataSourceFactory;
    private final GithubUserDataSource githubUserDataSource;

    private LiveData<PagedList<GithubUser>> githubUsers = new MediatorLiveData<>();
    private MutableLiveData<NetworkState> networkStateMutableLiveData;


    @ViewModelInject
    public LauncherActivityViewModel(GithubUserDataSourceFactory dataSourceFactory, GithubRepository repository, @Assisted SavedStateHandle savedStateHandle) {

        this.repository = repository;
        this.dataSourceFactory = dataSourceFactory;

        githubUserDataSource = (GithubUserDataSource) dataSourceFactory.create();

        networkStateMutableLiveData = new MutableLiveData<>();
        networkStateMutableLiveData.setValue(NetworkState.LOADED);

        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setEnablePlaceholders(false)
                .build();

        githubUsers = new LivePagedListBuilder(dataSourceFactory, config).build();
    }

    public LiveData<PagedList<GithubUser>> getGithubUsers() {
        return githubUsers;
    }

    public void invalidateDataSource() {
        githubUserDataSource.invalidate();
    }

    public LiveData<NetworkState> getRefreshState() {
        return networkStateMutableLiveData;
    }
}
