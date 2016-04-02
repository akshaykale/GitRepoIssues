package com.akshaykale.gitrepoissues;

/**
 * Created by Akshay on 4/1/2016.
 */
public class Constants {

    public static final int REQ_ISSUES = 0;
    public static final int REQ_USER = 1;
    public static final int REQ_COMMENTS = 2;
    //public static final int REQ_ISSUES = 0;

    public static final String SORT_UPDATED = "updated";
    public static final String SORT_CREATED = "created";
    public static final String SORT_CLOSED = "closed";

    public static String username = "rails";
    public static String repo = "rails";

    public static String SORT = SORT_UPDATED;

    public static String issueBaseURL = "https://api.github.com/repos/";

    public static String generateIssueURL (){
        return issueBaseURL + username +"/"+ repo +"/issues?sort="+SORT;
    }

    public static String generateCommentsURL (int number){
        return issueBaseURL + username +"/"+ repo +"/issues/"+number+"/comments?sort="+SORT_UPDATED;
    }
}
