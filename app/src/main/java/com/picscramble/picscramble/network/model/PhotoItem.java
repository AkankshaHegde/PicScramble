package com.picscramble.picscramble.network.model;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotoItem {
    private String id;
    private String imageUrl;

    public PhotoItem(String id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
