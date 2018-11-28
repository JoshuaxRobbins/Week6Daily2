package com.example.josh.amazonbooksexample.model.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.josh.amazonbooksexample.model.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    public void insert(Book...books);


    @Delete
    public void delete(Book book);

    @Query("SELECT * FROM booklist")
    public List<Book> getBooks();

    @Query("DELETE FROM booklist")
    public void deleteAll();

}
