package com.picscramble.picscramble.network.model;

import java.util.ArrayList;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotoSizesResponse {
    private ArrayList<PhotoSizeResponse> size;

    public PhotoSizesResponse(ArrayList<PhotoSizeResponse> size) {
        this.size = size;
    }

    public ArrayList<PhotoSizeResponse> getSize() {
        return size;
    }
}
