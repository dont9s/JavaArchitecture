package com.example.javaarchitecture.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class GithubUser {
    @PrimaryKey
    private int id;
    private String avatar_url;
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUser that = (GithubUser) o;
        return id == that.id &&
                (avatar_url == that.avatar_url ||
                        avatar_url.equalsIgnoreCase(that.avatar_url)) &&
                (login == that.login ||
                        login.equalsIgnoreCase(that.login));
    }

    @Override
    public int hashCode() {
        return id * 1000 + avatar_url.length() + login.length();
    }
}
