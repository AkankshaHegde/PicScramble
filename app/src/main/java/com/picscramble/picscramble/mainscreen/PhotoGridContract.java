package com.picscramble.picscramble.mainscreen;

import com.picscramble.picscramble.network.model.PhotoItemResponse;
import com.picscramble.picscramble.network.model.PhotosResponse;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotoGridContract {
    interface View {
        void showPosts(PhotosResponse posts);
        void showError(String message);
        void showComplete();
        void showPhotos(PhotoItemResponse photosResponse);
    }

    interface Presenter {
        void loadPost();
        void loadPhoto(String id);
    }
}
