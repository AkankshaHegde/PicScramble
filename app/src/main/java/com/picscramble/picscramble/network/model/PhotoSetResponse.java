package com.picscramble.picscramble.network.model;

import java.util.ArrayList;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotoSetResponse {
    private ArrayList<PhotoItem> photo;

    public PhotoSetResponse(ArrayList<PhotoItem> photo) {
        this.photo = photo;
    }

    public ArrayList<PhotoItem> getPhotoItem() {
        return photo;
    }
}
