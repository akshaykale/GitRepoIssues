package com.akshaykale.datamodel;

import java.util.Date;

/**
 * Created by Akshay on 4/1/2016.
 */
public class Issue {

    /**
 * {
 "url": "https://api.github.com/repos/crashlytics/secureudid/issues/13",
 "repository_url": "https://api.github.com/repos/crashlytics/secureudid",
 "labels_url": "https://api.github.com/repos/crashlytics/secureudid/issues/13/labels{/name}",
 "comments_url": "https://api.github.com/repos/crashlytics/secureudid/issues/13/comments",
 "events_url": "https://api.github.com/repos/crashlytics/secureudid/issues/13/events",
 "html_url": "https://github.com/crashlytics/secureudid/issues/13",
 "id": 3923240,
 "number": 13,
 "title": "Not working with ARC",
 "user": {
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
 "site_admin": false
 },
 "labels": [

 ],
 "state": "open",
 "locked": false,
 "assignee": null,
 "milestone": null,
 "comments": 10,
 "created_at": "2012-04-02T09:18:15Z",
 "updated_at": "2012-04-04T14:20:28Z",
 "closed_at": null,
 "body": "Hi,\r\n\r\nI tried to get the code running with ARC, so I changed the current code like this:\r\n\r\n\r\n CFUUIDRef uuid = CFUUIDCreate(kCFAllocatorDefault);\r\n        identifier = CFBridgingRelease(CFUUIDCreateString(kCFAllocatorDefault, uuid));\r\n        CFRelease(uuid);\r\n\r\nBut I get an EXC_BAD_ACCESS during runtime. Can you test your code with ARC?\r\n\r\nBest regards,\r\nSascha"
 }
 *
 * */


    private String mCommentUrl,mHtmlUrl;
    private String mTitle,mBody;
    private String mState;
    private int mId,mComments,mNumbers;
    private Date mCreatedAt,mUpdatedAt,mClosedAt;
    private User user;

    public int getmNumbers() {
        return mNumbers;
    }

    public void setmNumbers(int mNumbers) {
        this.mNumbers = mNumbers;
    }

    public Issue() {
        this.mCommentUrl = "";
        this.mHtmlUrl = "";
        this.mTitle = "";
        this.mBody = "";
        this.mState = "";
        this.mId = 0;
        this.mComments = 0;
        this.mCreatedAt = null;
        this.mUpdatedAt = null;
        this.mClosedAt = null;
        this.user = new User();
        this.mNumbers = 0;
    }

    public String getmCommentUrl() {
        return mCommentUrl;
    }

    public void setmCommentUrl(String mCommentUrl) {
        this.mCommentUrl = mCommentUrl;
    }

    public String getmHtmlUrl() {
        return mHtmlUrl;
    }

    public void setmHtmlUrl(String mHtmlUrl) {
        this.mHtmlUrl = mHtmlUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmComments() {
        return mComments;
    }

    public void setmComments(int mComments) {
        this.mComments = mComments;
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

    public Date getmClosedAt() {
        return mClosedAt;
    }

    public void setmClosedAt(Date mClosedAt) {
        this.mClosedAt = mClosedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
