package com.akshaykale.gitrepoissues;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akshaykale.datamodel.Issue;

import java.util.ArrayList;

public class RecyclerViewAdapter_Holder extends RecyclerView.Adapter<RecyclerViewAdapter_Holder.RecyclerViewHolder>{

    private final String TAG = "RecycleAdptr";
    private LayoutInflater inflater;
    private ArrayList<Issue> issueList;
    private Context context;
    private RecycleClickListner clickListener;

    //for adding fonts
    private Typeface tfRobotoThin,tfRobotoThinItalic,tfRobotoLight;

    public RecyclerViewAdapter_Holder(Context context, ArrayList<Issue> list){
        inflater = LayoutInflater.from(context);
        this.issueList = list;
        this.context = context;

        //set Typefaces fonts
        tfRobotoLight = Typeface.createFromAsset(context.getAssets(),"RobotoLight.ttf");
        tfRobotoThin = Typeface.createFromAsset(context.getAssets(),"RobotoThin.ttf");
        tfRobotoThinItalic = Typeface.createFromAsset(context.getAssets(),"RobotoThinItalic.ttf");
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.issuelist_custom_row_layout, parent, false);
        RecyclerViewHolder myViewHolder = new RecyclerViewHolder(context,view);

        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Issue current = issueList.get(position);

        if(holder.tv_title!=null) holder.tv_title.setText(current.getmTitle());

        if(holder.tv_login!=null) holder.tv_login.setText(current.getUser().getmLogin());

        String body = current.getmBody().replace("\n","");
        body = body.length()>140 ? body.substring(0,140) : body;
        if (body.equals("")) body = "Discription not available";
        if(holder.tv_desc!=null) holder.tv_desc.setText(body);

        //set date on which issue last updated
        if(holder.tv_time!=null)holder.tv_time.setText(""+current.getmUpdatedAt().toString().substring(0,20));



    }


    public void setClickListener(RecycleClickListner clickListener){
        this.clickListener = clickListener;
    }


    @Override
    public int getItemCount() {
        Log.d(TAG,"post count "+issueList.size());
        return issueList.size();
    }

    ///////////////////
    //////*********************
    ///////////////////

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_title, tv_desc, tv_time,tv_login;
        ImageView iv_image;
        Context context;

        public RecyclerViewHolder(final Context context, View itemView) {
            super(itemView);

            this.context = context;

            itemView.setOnClickListener(this);

            tv_title = (TextView) itemView.findViewById(R.id.tv_row_title);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_row_desc);
            tv_time = (TextView) itemView.findViewById(R.id.tv_row_time);
            tv_login = (TextView) itemView.findViewById(R.id.tv_row_user);
            iv_image = (ImageView) itemView.findViewById(R.id.tv_row_icon);

            //set typeface
            if(tv_title!=null) tv_title.setTypeface(tfRobotoLight);
            if(tv_desc!=null) tv_desc.setTypeface(tfRobotoThin);
            if(tv_login!=null) tv_login.setTypeface(tfRobotoThin);
            if(tv_time!=null) tv_time.setTypeface(tfRobotoThinItalic);
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null)
            {
                clickListener.itemClick(v,getAdapterPosition());
            }
        }
    }

    /** Interface for click event*/
    public interface RecycleClickListner{
        void itemClick(View view, int position);
    }
}
