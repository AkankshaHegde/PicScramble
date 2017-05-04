package com.picscramble.picscramble.network.model;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotoItemResponse {

    private PhotoSizesResponse sizes;

    public PhotoItemResponse(PhotoSizesResponse sizes) {
        this.sizes = sizes;
    }

    public PhotoSizesResponse getSizes() {
        return sizes;
    }
}
