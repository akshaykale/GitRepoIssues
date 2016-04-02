package com.akshaykale.gitrepoissues;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.akshaykale.datamodel.Comment;
import com.akshaykale.network.RequestCommentsDataAsyncTask;

import java.util.ArrayList;

/**
 * Created by Akshay on 4/2/2016.
 */
public class CommentsActivity extends AppCompatActivity
        implements RecyclerViewAdapter_Holder_Comments.RecycleClickListner, RequestCommentsDataAsyncTask.EventListner {

    private static final String TAG = "CommentsActivity";
    private RecyclerView mRecyclerView;
    private TextView tv_nocomments;
    private ProgressDialog mProgressDialog;

    private ArrayList<Comment> commentsList;

    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comments_layout);

        number = getIntent().getIntExtra("number", -1);

        init();
        if (number >= 0)
            requestIssueData();
    }

    private void requestIssueData() {
        showProgressDialog();
        tv_nocomments.setVisibility(View.GONE);
        /** Check for internet connectivity*/
        if (Utils.isOnline(getApplicationContext())) {
            RequestCommentsDataAsyncTask requestDataAsyncTask = new RequestCommentsDataAsyncTask(this);//this -> eventListener
            requestDataAsyncTask.execute(Constants.generateCommentsURL(number));
        } else{
            hideProgressDialog();
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            tv_nocomments.setText("No internet connection");
            tv_nocomments.setVisibility(View.VISIBLE);
        }
    }

    private void init() {
        commentsList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_comments);
        tv_nocomments = (TextView) findViewById(R.id.tv_nocomments);
    }

    public void setupRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter_Holder_Comments mAdapter = new RecyclerViewAdapter_Holder_Comments(getApplicationContext(), commentsList);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * When list item clicked
     */
    @Override
    public void itemClick(View view, int position) {

    }

    /**
     * data loaded and parsed
     */
    @Override
    public void onPostExecuteEvent(ArrayList<Comment> cL) {
        Log.d(TAG, "onpost event" + cL.size());
        commentsList = cL;
        if (cL.size() > 0)
            setupRecyclerView();
        else tv_nocomments.setVisibility(View.VISIBLE);
        hideProgressDialog();
    }

    /**
     * --------------------
     * --Helper functions for progressbar
     * --------------------
     */
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading comments...");
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }


}
