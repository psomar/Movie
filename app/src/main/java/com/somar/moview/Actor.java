package com.somar.moview;

import com.google.gson.annotations.SerializedName;

public class Actor {

    @SerializedName("name")
    private String name;
    @SerializedName("photo")
    private String photo;

    public Actor(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
