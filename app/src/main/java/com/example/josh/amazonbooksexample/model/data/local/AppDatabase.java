package com.example.josh.amazonbooksexample.model.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.josh.amazonbooksexample.model.Book;

@Database(entities = {Book.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookDao getBookDao();
}
