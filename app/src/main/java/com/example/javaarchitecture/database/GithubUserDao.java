package com.example.javaarchitecture.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.javaarchitecture.data.GithubUser;

import java.util.List;

@Dao
public interface GithubUserDao {

    @Query("SELECT * FROM githubuser")
    DataSource.Factory<Integer, GithubUser> getAllUsers();

    @Insert
    void insertAll(List<GithubUser> users);

}
