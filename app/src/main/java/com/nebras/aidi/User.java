package com.nebras.aidi;

import java.io.Serializable;

/**
 * Created by mahmoudkamal on 11/5/17.
 */

public class User implements Serializable {
    private String name,image;
    private boolean online;


    public User(String name, String image, boolean online) {
        this.name = name;
        this.image = image;
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
