package com.example.josh.amazonbooksexample.model.data.local;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.example.josh.amazonbooksexample.model.Book;
import com.example.josh.amazonbooksexample.ui.booklist.BookListActivity;

import java.util.List;

public class LocalDataSource {
    public BookDao bookDao;
    public LocalDataSource() {
        bookDao = createDao();
    }

    public List<Book> getBooks(){

        return bookDao.getBooks();

    }

    public void storeBook(Book book){
        bookDao.insert(book);
    }


    private BookDao createDao(){
        AppDatabase database = Room.databaseBuilder(BookListActivity.getAppContext(),AppDatabase.class,"booklist")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        return database.getBookDao();
    }

    public void storeAllBooks(List<Book> bookList){
        for (Book book: bookList) {
            storeBook(book);
        }
    }

    public void removeBooks(){
        bookDao.deleteAll();
    }

}
