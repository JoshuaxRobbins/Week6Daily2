package com.example.josh.amazonbooksexample.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "booklist")
public class Book {

    @PrimaryKey(autoGenerate = true)
    private int bookId;

    @ColumnInfo(name = "image")
    @SerializedName("imageURL")
    private String imageURL = "";

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title = "";

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

    public String getImageURL(){
        return imageURL;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString(){
        return
                "Book{" +
                        "imageURL = '" + imageURL + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
}
