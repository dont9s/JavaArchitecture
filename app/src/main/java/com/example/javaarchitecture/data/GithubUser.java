
package com.example.javaarchitecture.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class GithubUser {

    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    private String avatarUrl;
    @ColumnInfo(name = "events_url")
    private String eventsUrl;
    @ColumnInfo(name = "followers_url")
    private String followersUrl;
    @ColumnInfo(name = "following_url")
    private String followingUrl;
    @ColumnInfo(name = "gists_url")
    private String gistsUrl;
    @ColumnInfo(name = "gravatar_id")
    private String gravatarId;
    @ColumnInfo(name = "html_url")
    private String htmlUrl;
    @NonNull
    @PrimaryKey
    private Long id;
    @ColumnInfo(name = "login")
    private String login;

    @ColumnInfo(name = "node_id")
    private String nodeId;
    @ColumnInfo(name = "organizations_url")
    private String organizationsUrl;
    @ColumnInfo(name = "received_events_url")
    private String receivedEventsUrl;
    @ColumnInfo(name = "repos_url")
    private String reposUrl;
    @ColumnInfo(name = "site_admin")
    private Boolean siteAdmin;
    @ColumnInfo(name = "starred_url")
    private String starredUrl;
    @ColumnInfo(name = "subscriptions_url")
    private String subscriptionsUrl;
    @Expose
    private String type;
    @Expose
    private String url;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUser that = (GithubUser) o;
        return id == that.id &&
                (avatarUrl == that.avatarUrl ||
                        avatarUrl.equalsIgnoreCase(that.avatarUrl)) &&
                (login == that.login ||
                        login.equalsIgnoreCase(that.login));
    }

    @Override
    public int hashCode() {
        return (int) (id * 1000 + avatarUrl.length() + login.length());
    }

}
