package com.akshaykale.datamodel;

import java.util.Date;

/**
 * Created by Akshay on 4/1/2016.
 */
public class Comment {
    /**
 * {
 "url": "https://api.github.com/repos/rails/rails/issues/comments/204737778",
 "html_url": "https://github.com/rails/rails/issues/24402#issuecomment-204737778",
 "issue_url": "https://api.github.com/repos/rails/rails/issues/24402",
 "id": 204737778,
 "user": {
 "login": "maclover7",
 "id": 3020626,
 "avatar_url": "https://avatars.githubusercontent.com/u/3020626?v=3",
 "gravatar_id": "",
 "url": "https://api.github.com/users/maclover7",
 "html_url": "https://github.com/maclover7",
 "followers_url": "https://api.github.com/users/maclover7/followers",
 "following_url": "https://api.github.com/users/maclover7/following{/other_user}",
 "gists_url": "https://api.github.com/users/maclover7/gists{/gist_id}",
 "starred_url": "https://api.github.com/users/maclover7/starred{/owner}{/repo}",
 "subscriptions_url": "https://api.github.com/users/maclover7/subscriptions",
 "organizations_url": "https://api.github.com/users/maclover7/orgs",
 "repos_url": "https://api.github.com/users/maclover7/repos",
 "events_url": "https://api.github.com/users/maclover7/events{/privacy}",
 "received_events_url": "https://api.github.com/users/maclover7/received_events",
 "type": "User",
 "site_admin": false
 },
 "created_at": "2016-04-02T15:31:10Z",
 "updated_at": "2016-04-02T15:31:10Z",
 "body": " Can you create an executable test script using one of the templates [here](https://github.com/rails/rails/tree/master/guides/bug_report_templates), that would demonstrate the problem you are seeing?\r\n"
 }
 * */
    private String mBody;
    private Date mCreatedAt,mUpdatedAt;
    private User mUser;
    int id;


    public Comment(String mBody, Date mCreatedAt, Date mUpdatedAt, User mUser) {
        this.mBody = mBody;
        this.mCreatedAt = mCreatedAt;
        this.mUpdatedAt = mUpdatedAt;
        this.mUser = mUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comment() {
        this.mBody = "";
        this.mCreatedAt = null;
        this.mUpdatedAt = null;
        this.mUser = new User();
        id = 0;
    }


    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }

    public Date getmCreatedAt() {
        return mCreatedAt;
    }

    public void setmCreatedAt(Date mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    public Date getmUpdatedAt() {
        return mUpdatedAt;
    }

    public void setmUpdatedAt(Date mUpdatedAt) {
        this.mUpdatedAt = mUpdatedAt;
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

}
