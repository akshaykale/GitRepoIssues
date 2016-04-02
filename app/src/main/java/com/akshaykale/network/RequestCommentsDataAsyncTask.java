package com.akshaykale.network;

import android.os.AsyncTask;
import android.util.Log;

import com.akshaykale.datamodel.Comment;

import java.util.ArrayList;

/**
 * Created by Akshay on 4/1/2016.
 */
public class RequestCommentsDataAsyncTask extends AsyncTask<String,String,ArrayList<Comment>>{

    private static final String TAG = "";
    private EventListner eventListener;

    public RequestCommentsDataAsyncTask(EventListner eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    protected ArrayList<Comment> doInBackground(String... params) {
        /** Request data from server*/
        String response = HttpManager.getData(params[0]);

        /** Parse the response*/
        return ParserUtils.parseComments(response);
    }

    @Override
    protected void onPostExecute(ArrayList<Comment> comments) {
        Log.d(TAG,"issuelist"+ comments.size());
        super.onPostExecute(comments);
        eventListener.onPostExecuteEvent(comments);
    }


    /** Interface for click event*/
    public interface EventListner{
        void onPostExecuteEvent(ArrayList<Comment> issueList);
    }
}
