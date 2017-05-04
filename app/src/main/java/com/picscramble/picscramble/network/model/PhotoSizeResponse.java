package com.picscramble.picscramble.network.model;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PhotoSizeResponse {
    private String label;
    private String source;

    public PhotoSizeResponse(String label, String source) {
        this.label = label;
        this.source = source;
    }

    public String getLabel() {
        return label;
    }

    public String getSource() {
        return source;
    }
}
