package com.narendra.shortener.model;

import java.io.Serializable;

public class ShortenerRequest implements Serializable {
    private String longUrl;

    public String getLongUrl() {
        return longUrl;
    }
    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
