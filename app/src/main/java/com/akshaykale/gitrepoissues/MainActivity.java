package com.akshaykale.gitrepoissues;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.akshaykale.datamodel.Issue;
import com.akshaykale.network.RequestDataAsyncTask;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements RecyclerViewAdapter_Holder.RecycleClickListner, RequestDataAsyncTask.EventListner

{
    private static final String TAG = "MainActivity";
    private ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerView;

    private ArrayList<Issue> mIssueList;
    private TextView tv_noissues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();//initialize data/UI

        requestIssueData();//req for data from git api
    }

    private void requestIssueData() {
        showProgressDialog();
        tv_noissues.setVisibility(View.GONE);
        /** Check for internet connectivity*/
        if (Utils.isOnline(getApplicationContext())) {
            RequestDataAsyncTask requestDataAsyncTask = new RequestDataAsyncTask(this);//this -> eventListener
            requestDataAsyncTask.execute(Constants.generateIssueURL());
        } else {
            hideProgressDialog();
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            tv_noissues.setVisibility(View.VISIBLE);
        }
    }

    private void init() {
        mIssueList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        tv_noissues = (TextView) findViewById(R.id.tv_noissues);
    }

    public void setupRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter_Holder mAdapter = new RecyclerViewAdapter_Holder(getApplicationContext(), mIssueList);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_change_repo) {
            final Dialog d = new Dialog(MainActivity.this);
            d.setContentView(R.layout.change_repo_layout);
            d.setCancelable(true);
            d.setTitle("Chenge repo");
            final EditText et_username = (EditText) d.findViewById(R.id.et_username);
            final EditText et_repo = (EditText) d.findViewById(R.id.et_repo);
            Button bt_change = (Button) d.findViewById(R.id.bt_change);
            bt_change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (et_username.equals(""))
                        et_username.setError("Invalid");
                    else if (et_repo.equals(""))
                        et_repo.setError("Invalid");
                    else {
                        Constants.username = et_username.getText().toString();
                        Constants.repo = et_repo.getText().toString();
                        d.dismiss();
                        requestIssueData();
                    }
                }
            });

            d.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * When list item clicked
     */
    @Override
    public void itemClick(View view, int position) {
        Intent intent = new Intent(MainActivity.this, CommentsActivity.class);
        intent.putExtra("number",mIssueList.get(position).getmNumbers());
        startActivity(intent);
    }

    /**
     * data loaded and parsed
     */
    @Override
    public void onPostExecuteEvent(ArrayList<Issue> issueList) {
        Log.d(TAG, "onpost event" + issueList.size());
        mIssueList = issueList;
        if (issueList.size() == 0)
        tv_noissues.setVisibility(View.VISIBLE);
        setupRecyclerView();
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
            mProgressDialog.setMessage("Loading open issues...");
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
