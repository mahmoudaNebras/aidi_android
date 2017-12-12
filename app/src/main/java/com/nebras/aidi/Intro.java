package com.nebras.aidi;

import java.io.Serializable;

/**
 * Created by mahmoudkamal on 11/5/17.
 */

public class Intro implements Serializable {
    private String title,descriptiopn;
    private int image;


    public Intro(String title, String descriptiopn, int image) {
        this.title = title;
        this.descriptiopn = descriptiopn;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptiopn() {
        return descriptiopn;
    }

    public void setDescriptiopn(String descriptiopn) {
        this.descriptiopn = descriptiopn;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
