package com.picscramble.picscramble.network.model;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotosResponse {

    private PhotoSetResponse photos;

    public PhotosResponse(PhotoSetResponse photos) {
        this.photos = photos;
    }

    public PhotoSetResponse getPhotoSetResponse() {
        return photos;
    }
}
