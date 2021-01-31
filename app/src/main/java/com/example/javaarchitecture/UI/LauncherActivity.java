package com.example.javaarchitecture.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.javaarchitecture.R;
import com.example.javaarchitecture.adapter.GithubUserListAdapter;
import com.example.javaarchitecture.databinding.ActivityLauncherBinding;
import com.example.javaarchitecture.viewmodel.LauncherActivityViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LauncherActivity extends AppCompatActivity {


    GithubUserListAdapter adapter;

    private LauncherActivityViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityLauncherBinding launcherBinding = DataBindingUtil.setContentView(this, R.layout.activity_launcher);

        viewModel = new ViewModelProvider(this).get(LauncherActivityViewModel.class);


        adapter = new GithubUserListAdapter();
        launcherBinding.rvGithubUsers.setLayoutManager(new LinearLayoutManager(this));
        launcherBinding.rvGithubUsers.setAdapter(adapter);

        viewModel.getGithubUsers().observe(this, adapter::submitList);

        viewModel.getRefreshState()

        launcherBinding.srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.invalidateDataSource();
            }
        });


    }
}
