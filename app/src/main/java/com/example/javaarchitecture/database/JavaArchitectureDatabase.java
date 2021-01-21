package com.example.javaarchitecture.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.javaarchitecture.data.GithubUser;

@Database(entities = GithubUser.class, version = 1)
public abstract class JavaArchitectureDatabase extends RoomDatabase {

    public abstract GithubUserDao githubUserDao();
}
