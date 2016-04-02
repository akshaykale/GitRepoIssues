package com.akshaykale.gitrepoissues;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akshaykale.datamodel.Comment;

import java.io.InputStream;
import java.util.ArrayList;

public class RecyclerViewAdapter_Holder_Comments extends RecyclerView.Adapter<RecyclerViewAdapter_Holder_Comments.RecyclerViewHolder> {

    private final String TAG = "RecyclerViewAdapter_Holder_Comments";
    private LayoutInflater inflater;
    private ArrayList<Comment> commentList;
    private Context context;
    private RecycleClickListner clickListener;

    //for adding fonts
    private Typeface tfRobotoThin, tfRobotoThinItalic, tfRobotoLight;

    public RecyclerViewAdapter_Holder_Comments(Context context, ArrayList<Comment> list) {
        inflater = LayoutInflater.from(context);
        this.commentList = list;
        this.context = context;

        //set Typefaces fonts
        tfRobotoLight = Typeface.createFromAsset(context.getAssets(), "RobotoLight.ttf");
        tfRobotoThin = Typeface.createFromAsset(context.getAssets(), "RobotoThin.ttf");
        tfRobotoThinItalic = Typeface.createFromAsset(context.getAssets(), "RobotoThinItalic.ttf");
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.commentlist_custom_row_layout, parent, false);
        RecyclerViewHolder myViewHolder = new RecyclerViewHolder(context, view);

        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Comment current = commentList.get(position);

        //set pic first since it will take time to load
        if (holder.iv_image != null)
            new DownloadImageTask(holder.iv_image)
                    .execute(current.getmUser().getmAvatarUrl());
        //set Title
        if (holder.tv_title != null) holder.tv_title.setText(current.getmBody());

        if (holder.tv_user != null) holder.tv_user.setText(current.getmUser().getmLogin());

        //set date on which article posted
        if (holder.tv_time != null) {
            if (current.getmUpdatedAt() != null)
                holder.tv_time.setText("" + current.getmUpdatedAt());
            else
                holder.tv_time.setText("" + current.getmCreatedAt());
        }


    }


    public void setClickListener(RecycleClickListner clickListener) {
        this.clickListener = clickListener;
    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "post count " + commentList.size());
        return commentList.size();
    }

    ///////////////////
    //////*********************
    ///////////////////

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_title, tv_user, tv_time;
        ImageView iv_image;
        Context context;

        public RecyclerViewHolder(final Context context, View itemView) {
            super(itemView);

            this.context = context;

            itemView.setOnClickListener(this);

            tv_title = (TextView) itemView.findViewById(R.id.tv_row_title);
            tv_user = (TextView) itemView.findViewById(R.id.tv_row_user);
            tv_time = (TextView) itemView.findViewById(R.id.tv_row_time);
            iv_image = (ImageView) itemView.findViewById(R.id.tv_row_icon);

            //set typeface
            if (tv_title != null) tv_title.setTypeface(tfRobotoLight);
            if (tv_user != null) tv_user.setTypeface(tfRobotoThin);
            if (tv_time != null) tv_time.setTypeface(tfRobotoThinItalic);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClick(v, getAdapterPosition());
            }
        }
    }

    /**
     * Interface for click event
     */
    public interface RecycleClickListner {
        void itemClick(View view, int position);
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
