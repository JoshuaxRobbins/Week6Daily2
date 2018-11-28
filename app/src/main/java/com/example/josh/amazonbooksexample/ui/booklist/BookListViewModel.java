package com.example.josh.amazonbooksexample.ui.booklist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.josh.amazonbooksexample.model.Book;
import com.example.josh.amazonbooksexample.model.data.BookRepository;
import com.example.josh.amazonbooksexample.model.data.local.LocalDataSource;
import com.example.josh.amazonbooksexample.model.data.remote.RemoteDataSource;

import java.util.List;

public class BookListViewModel extends ViewModel {

    BookRepository bookRepository;

    public BookListViewModel() {
        bookRepository = new BookRepository(new RemoteDataSource(),new LocalDataSource());
    }

    public LiveData<List<Book>> getBooks(){
        return bookRepository.getBooks();
    }
}
