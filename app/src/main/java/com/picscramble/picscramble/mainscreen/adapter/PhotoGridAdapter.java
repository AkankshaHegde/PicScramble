package com.picscramble.picscramble.mainscreen.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.picscramble.picscramble.R;
import com.picscramble.picscramble.network.model.PhotoItem;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotoGridAdapter extends RecyclerView.Adapter<PhotoGridAdapter.ViewHolder> {

    private ArrayList<PhotoItem> mPhotosList;
    private PhotoApiListener mPhotoApiListener;
    private Activity mContext;

    public PhotoGridAdapter(Activity context, ArrayList<PhotoItem> inPhotosList, PhotoApiListener inPhotoApiListener) {
        mContext = context;
        mPhotosList = inPhotosList;
        mPhotoApiListener = inPhotoApiListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_grid_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public interface PhotoApiListener {
        public void loadPhotoFromId(String id);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {
            final PhotoItem item = mPhotosList.get(position);
            if (item != null) {
                setImagesToView(item.getId(), holder);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        if (mPhotosList != null)
            return mPhotosList.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPhotoItem;
        private ProgressBar mPhotoProgress;

        public ViewHolder(View itemView) {
            super(itemView);
            mPhotoItem = (ImageView) itemView.findViewById(R.id.photo_item);
            mPhotoProgress = (ProgressBar) itemView.findViewById(R.id.progress_spinner);
        }
    }

    /**
     * METHOD USED TO SET IMAGES TO THE VIEW FROM THE RESPONSE
     */
    private void setImagesToView(String photoId, final ViewHolder holder) {
        if (photoId != null) {
            holder.mPhotoProgress.setVisibility(View.VISIBLE);
            mPhotoApiListener.loadPhotoFromId(photoId);
        }

        Picasso.with(mContext)
                .load("http://i.imgur.com/DvpvklR.png")
                .fit()
                .into(holder.mPhotoItem, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.mPhotoProgress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        // TODO Auto-generated method stub

                    }
                });
    }
}





