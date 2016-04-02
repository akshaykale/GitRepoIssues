package com.akshaykale.datamodel;

/**
 * Created by Akshay on 4/1/2016.
 */
public class User {
    /**
     * {
     "login": "SaschaMoellering",
     "id": 1321549,
     "avatar_url": "https://avatars.githubusercontent.com/u/1321549?v=3",
     "gravatar_id": "",
     "url": "https://api.github.com/users/SaschaMoellering",
     "html_url": "https://github.com/SaschaMoellering",
     "followers_url": "https://api.github.com/users/SaschaMoellering/followers",
     "following_url": "https://api.github.com/users/SaschaMoellering/following{/other_user}",
     "gists_url": "https://api.github.com/users/SaschaMoellering/gists{/gist_id}",
     "starred_url": "https://api.github.com/users/SaschaMoellering/starred{/owner}{/repo}",
     "subscriptions_url": "https://api.github.com/users/SaschaMoellering/subscriptions",
     "organizations_url": "https://api.github.com/users/SaschaMoellering/orgs",
     "repos_url": "https://api.github.com/users/SaschaMoellering/repos",
     "events_url": "https://api.github.com/users/SaschaMoellering/events{/privacy}",
     "received_events_url": "https://api.github.com/users/SaschaMoellering/received_events",
     "type": "User",
     "site_admin": false,
     "name": "Sascha Möllering",
     "company": "http://autoscaling.io",
     "blog": null,
     "location": "Berlin",
     "email": "sascha.moellering@gmail.com",
     "hireable": null,
     "bio": null,
     "public_repos": 30,
     "public_gists": 17,
     "followers": 15,
     "following": 3,
     "created_at": "2012-01-11T11:54:01Z",
     "updated_at": "2016-03-22T15:36:37Z"
     }
     * */

    private String mLogin,mName,mCompany,mLocation,mEmail;
    private int mId,mPublicRepos,mPublicGists,mFollowers,mFollowing;
    private String mAvatarUrl,mHtmlUrl,mReposUrl;

    public User(String mLogin, String mName, String mCompany, String mLocation, String mEmail, int mId, int mPublicRepos, int mPublicGists, int mFollowers, int mFollowing, String mAvatarUrl, String mHtmlUrl, String mReposUrl) {
        this.mLogin = mLogin;
        this.mName = mName;
        this.mCompany = mCompany;
        this.mLocation = mLocation;
        this.mEmail = mEmail;
        this.mId = mId;
        this.mPublicRepos = mPublicRepos;
        this.mPublicGists = mPublicGists;
        this.mFollowers = mFollowers;
        this.mFollowing = mFollowing;
        this.mAvatarUrl = mAvatarUrl;
        this.mHtmlUrl = mHtmlUrl;
        this.mReposUrl = mReposUrl;
    }

    public User() {
        this.mLogin = "";
        this.mName = "";
        this.mCompany = "";
        this.mLocation = "";
        this.mEmail = "";
        this.mId = 0;
        this.mPublicRepos = 0;
        this.mPublicGists = 0;
        this.mFollowers = 0;
        this.mFollowing = 0;
        this.mAvatarUrl = "";
        this.mHtmlUrl = "";
        this.mReposUrl = "";
    }


    public String getmLogin() {
        return mLogin;
    }
    public void setmLogin(String mLogin) {
        this.mLogin = mLogin;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getmCompany() {
        return mCompany;
    }
    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }
    public String getmLocation() {
        return mLocation;
    }
    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }
    public String getmEmail() {
        return mEmail;
    }
    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
    public int getmId() {
        return mId;
    }
    public void setmId(int mId) {
        this.mId = mId;
    }
    public int getmPublicRepos() {
        return mPublicRepos;
    }
    public void setmPublicRepos(int mPublicRepos) {
        this.mPublicRepos = mPublicRepos;
    }
    public int getmPublicGists() {
        return mPublicGists;
    }
    public void setmPublicGists(int mPublicGists) {
        this.mPublicGists = mPublicGists;
    }
    public int getmFollowers() {
        return mFollowers;
    }
    public void setmFollowers(int mFollowers) {
        this.mFollowers = mFollowers;
    }
    public int getmFollowing() {
        return mFollowing;
    }
    public void setmFollowing(int mFollowing) {
        this.mFollowing = mFollowing;
    }
    public String getmAvatarUrl() {
        return mAvatarUrl;
    }
    public void setmAvatarUrl(String mAvatarUrl) {
        this.mAvatarUrl = mAvatarUrl;
    }
    public String getmHtmlUrl() {
        return mHtmlUrl;
    }
    public void setmHtmlUrl(String mHtmlUrl) {
        this.mHtmlUrl = mHtmlUrl;
    }
    public String getmReposUrl() {
        return mReposUrl;
    }
    public void setmReposUrl(String mReposUrl) {
        this.mReposUrl = mReposUrl;
    }
}
