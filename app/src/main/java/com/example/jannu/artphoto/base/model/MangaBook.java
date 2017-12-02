package com.example.jannu.artphoto.base.model;

/**
 * Created by jannu on 11/30/17.
 */

public class MangaBook {

    private String Author;
    private String Year;
    private String Title;
    private int imageResId;

    public MangaBook(String author, String year, String title, int imageResId) {
        Author = author;
        Year = year;
        Title = title;
        this.imageResId = imageResId;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
