package com.example.jannu.artphoto.base.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jannu on 11/30/17.
 */

public class MangaBook implements Parcelable{

    private String author;
    private int year;
    private String title;
    private int imageResId;

    public MangaBook(String author, int year, String title, int imageResId) {
        this.author = author;
        this.year = year;
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeInt(this.year);
        dest.writeString(this.title);
        dest.writeInt(this.imageResId);
    }

    protected MangaBook(Parcel in) {
        this.author = in.readString();
        this.year = in.readInt();
        this.title = in.readString();
        this.imageResId = in.readInt();
    }

    public static final Creator<MangaBook> CREATOR = new Creator<MangaBook>() {
        @Override
        public MangaBook createFromParcel(Parcel source) {
            return new MangaBook(source);
        }

        @Override
        public MangaBook[] newArray(int size) {
            return new MangaBook[size];
        }
    };
}
