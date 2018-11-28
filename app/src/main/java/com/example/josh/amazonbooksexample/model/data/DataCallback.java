package com.example.josh.amazonbooksexample.model.data;

import com.example.josh.amazonbooksexample.model.Book;

import java.util.List;

public interface DataCallback {

    void onSuccess(List<Book> bookList);

    void onFailure(String error);
}
