package com.example.javaarchitecture.retrofit;

import com.example.javaarchitecture.data.GithubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubUserApi {

    @GET("users")
    Call<List<GithubUser>> getUsersAsync();
}
