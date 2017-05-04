package com.picscramble.picscramble.mainscreen;

import com.picscramble.picscramble.network.model.PhotoItemResponse;
import com.picscramble.picscramble.network.model.PhotosResponse;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotoGridPresenter implements PhotoGridContract.Presenter {
    Retrofit retrofit;
    PhotoGridContract.View mView;
    private static String mPhotoId;

    @Inject
    public PhotoGridPresenter(Retrofit retrofit, PhotoGridContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadPost() {
        retrofit.create(PostService.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<PhotosResponse>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(PhotosResponse posts) {
                        mView.showPosts(posts);
                    }
                });
    }

    @Override
    public void loadPhoto(String id) {
        mPhotoId = id;
        retrofit.create(PhotoItem.class).getPhotosList(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<PhotoItemResponse>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(PhotoItemResponse posts) {
                        mView.showPhotos(posts);
                    }
                });
    }

    public interface PostService {
        @GET("?method=flickr.photos.getRecent&api_key=46671ea5e3f746a35110c5196b7f0758&format=json&nojsoncallback=1")
        Observable<PhotosResponse> getPostList();
    }

    public interface PhotoItem {
        @GET("?method=flickr.photos.getSizes&api_key=46671ea5e3f746a35110c5196b7f0758&format=json&nojsoncallback=1")
        Observable<PhotoItemResponse> getPhotosList(@Query("photo_id") String id);
    }
}