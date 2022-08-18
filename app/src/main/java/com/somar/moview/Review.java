package com.somar.moview;

import androidx.room.Embedded;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("type")
    private String typeReview;
    @SerializedName("review")
    private String review;
    @SerializedName("author")
    private String author;

    public Review(String typeReview, String review, String author, Actor actor) {
        this.typeReview = typeReview;
        this.review = review;
        this.author = author;
    }

    public String getTypeReview() {
        return typeReview;
    }

    public String getReview() {
        return review;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Review{" +
                "typeReview='" + typeReview + '\'' +
                ", review='" + review + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
