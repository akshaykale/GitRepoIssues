package com.akshaykale.network;

import com.akshaykale.datamodel.Comment;
import com.akshaykale.datamodel.Issue;
import com.akshaykale.datamodel.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Akshay on 4/1/2016.
 */
public class ParserUtils {

    public static ArrayList<Issue> parseIssue(String response) {

        ArrayList<Issue> isueList = new ArrayList();

        try {
            JSONArray issueJsonArray = new JSONArray(response);

            for (int i = 0; i < issueJsonArray.length(); i++) {
                Issue issue = new Issue();
                JSONObject jsonObject = issueJsonArray.getJSONObject(i);

                issue.setmBody(jsonObject.getString("body"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                if (!jsonObject.isNull("closed_at"))
                    issue.setmClosedAt(sdf.parse(jsonObject.getString("closed_at").substring(0,jsonObject.getString("closed_at").length()-2)));
                if (!jsonObject.isNull("created_at"))
                    issue.setmCreatedAt(sdf.parse(jsonObject.getString("created_at").substring(0, jsonObject.getString("created_at").length() - 2)));
                if (!jsonObject.isNull("updated_at"))
                    issue.setmUpdatedAt(sdf.parse(jsonObject.getString("updated_at").substring(0,jsonObject.getString("updated_at").length()-2)));
                issue.setmComments(Integer.parseInt(jsonObject.getString("comments")));
                issue.setmCommentUrl(jsonObject.getString("comments_url"));
                issue.setmHtmlUrl(jsonObject.getString("html_url"));
                issue.setmId(jsonObject.getInt("id"));
                issue.setmState(jsonObject.getString("state"));
                issue.setmTitle(jsonObject.getString("title"));
                issue.setmNumbers(Integer.parseInt(jsonObject.getString("number")));

                JSONObject userJsonObject = jsonObject.getJSONObject("user");
                User user = new User();
                user.setmLogin(userJsonObject.getString("login"));
                user.setmId(userJsonObject.getInt("id"));
                user.setmAvatarUrl(userJsonObject.getString("avatar_url"));
                user.setmHtmlUrl(userJsonObject.getString("html_url"));
                user.setmReposUrl(userJsonObject.getString("repos_url"));

                issue.setUser(user);

                isueList.add(issue);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return isueList;
    }


    public static ArrayList<Comment> parseComments(String response){

        ArrayList<Comment> commentsList = new ArrayList<>();

        try {
            JSONArray commentJsonArray = new JSONArray(response);

            for (int i = 0; i < commentJsonArray.length(); i++) {
                Comment comment = new Comment();
                JSONObject jsonObject = commentJsonArray.getJSONObject(i);

                comment.setmBody(jsonObject.getString("body"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                if (!jsonObject.isNull("created_at"))
                    comment.setmCreatedAt(sdf.parse(jsonObject.getString("created_at").substring(0, jsonObject.getString("created_at").length() - 2)));
                if (!jsonObject.isNull("updated_at"))
                    comment.setmUpdatedAt(sdf.parse(jsonObject.getString("updated_at").substring(0,jsonObject.getString("updated_at").length()-2)));
                comment.setId(jsonObject.getInt("id"));

                JSONObject userJsonObject = jsonObject.getJSONObject("user");
                User user = new User();
                user.setmLogin(userJsonObject.getString("login"));
                user.setmId(userJsonObject.getInt("id"));
                user.setmAvatarUrl(userJsonObject.getString("avatar_url"));
                user.setmHtmlUrl(userJsonObject.getString("html_url"));
                user.setmReposUrl(userJsonObject.getString("repos_url"));

                comment.setmUser(user);

                commentsList.add(comment);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return commentsList;
    }
}
