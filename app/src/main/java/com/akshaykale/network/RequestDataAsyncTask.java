package com.akshaykale.network;

import android.os.AsyncTask;
import android.util.Log;

import com.akshaykale.datamodel.Issue;

import java.util.ArrayList;

/**
 * Created by Akshay on 4/1/2016.
 */
public class RequestDataAsyncTask extends AsyncTask<String,String,ArrayList<Issue>>{

    private static final String TAG = "";
    private EventListner eventListener;

    public RequestDataAsyncTask(EventListner eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    protected ArrayList<Issue> doInBackground(String... params) {
        /** Request data from server*/
        String response = HttpManager.getData(params[0]);

        /** Parse the response*/
        return ParserUtils.parseIssue(response);
    }

    @Override
    protected void onPostExecute(ArrayList<Issue> issues) {
        Log.d(TAG,"issuelist"+ issues.size());
        super.onPostExecute(issues);
        eventListener.onPostExecuteEvent(issues);
    }


    /** Interface for click event*/
    public interface EventListner{
        void onPostExecuteEvent(ArrayList<Issue> issueList);
    }
}
