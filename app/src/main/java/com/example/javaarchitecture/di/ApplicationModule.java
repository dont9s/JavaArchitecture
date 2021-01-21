package com.example.javaarchitecture.di;

import android.app.Application;

import androidx.room.Room;

import com.example.javaarchitecture.data.GithubUser;
import com.example.javaarchitecture.database.GithubUserDao;
import com.example.javaarchitecture.database.JavaArchitectureDatabase;
import com.example.javaarchitecture.repository.GithubRepository;
import com.example.javaarchitecture.retrofit.GithubUserApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public abstract class ApplicationModule {

    @Provides
    @Singleton
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public static Cache provideCache(Application application) {
        long cache = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cache);
    }

    @Provides
    public static OkHttpClient provideHttpClient(Cache cache) {
        return new OkHttpClient.Builder().cache(cache).build();
    }

    @Provides
    public static Gson provideGson() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
    }

    @Provides
    @Singleton
    public static JavaArchitectureDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                JavaArchitectureDatabase.class, "java-architecture").build();
    }

    @Provides
    public static GithubUserDao provideGithubUserDao(JavaArchitectureDatabase database) {
        return database.githubUserDao();
    }


    @Provides
    @Singleton
    public static GithubUserApi provideRetrofitServiceModule(Retrofit retrofit) {
        return retrofit.create(GithubUserApi.class);

    }

    @Singleton
    @Provides
    public static Executor getSingleCoreExecutor() {
        return Executors.newSingleThreadExecutor();
    }


    @Singleton
    @Provides
    public static GithubRepository getGithubRepository(GithubUserApi userApi,
                                                       GithubUserDao githubUserDao, Executor singleCoreExecutor) {
        return new GithubRepository(userApi, githubUserDao, singleCoreExecutor);
    }


}
