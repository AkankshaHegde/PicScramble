package com.picscramble.picscramble.mainscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.picscramble.picscramble.R;
import com.picscramble.picscramble.app.PicScrambleApplication;
import com.picscramble.picscramble.mainscreen.adapter.PhotoGridAdapter;
import com.picscramble.picscramble.network.model.PhotoItem;
import com.picscramble.picscramble.network.model.PhotoItemResponse;
import com.picscramble.picscramble.network.model.PhotoSizeResponse;
import com.picscramble.picscramble.network.model.PhotoSizesResponse;
import com.picscramble.picscramble.network.model.PhotosResponse;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements PhotoGridContract.View, PhotoGridAdapter.PhotoApiListener {
    private RecyclerView mPhotoGridView;
    private PhotoGridAdapter mPhotoGridAdapter;

    private ArrayList<PhotoItem> mPhotoItemArrayList;
    @Inject
    PhotoGridPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        DaggerPhotoGridComponent.builder()
                .netComponent(((PicScrambleApplication) getApplicationContext()).getNetComponent())
                .photoGridModule(new PhotoGridModule(this))
                .build().inject(this);


        //Call the method in MainPresenter to make Network Request
        mainPresenter.loadPost();
    }

    private void initializeViews() {
        mPhotoGridView = (RecyclerView) findViewById(R.id.photos_gridview);
        mPhotoGridView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    @Override
    public void showPosts(PhotosResponse posts) {
        Log.d("TAG", "photos size:" + posts.getPhotoSetResponse().getPhotoItem().size());
        mPhotoItemArrayList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            mPhotoItemArrayList.add(posts.getPhotoSetResponse().getPhotoItem().get(i));
        }

        Log.d("TAG", "Size:" + mPhotoItemArrayList.size());
        mPhotoGridAdapter = new PhotoGridAdapter(MainActivity.this, mPhotoItemArrayList, this);
        mPhotoGridView.setAdapter(mPhotoGridAdapter);
    }

    @Override
    public void showError(String message) {
        //Show error message Toast
        Log.d("TAG", message);
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showComplete() {
        //Show completed message Toast
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhotos(PhotoItemResponse photosResponse) {
        Log.d("TAG", "showPhotos");

        if(photosResponse != null) {
            if(photosResponse.getSizes() != null) {
                PhotoSizesResponse sizesResponse = photosResponse.getSizes();
                if(sizesResponse != null) {
                    ArrayList<PhotoSizeResponse> mSizeResponse = sizesResponse.getSize();
                    for(PhotoSizeResponse sizeResponse : mSizeResponse) {
                        if (sizeResponse.getLabel() != null && sizeResponse.getLabel().equalsIgnoreCase("Large Square")) {

                        }
                    }
                }
            }
        }
    }

    @Override
    public void loadPhotoFromId(String id) {
        mainPresenter.loadPhoto(id);
    }
}

