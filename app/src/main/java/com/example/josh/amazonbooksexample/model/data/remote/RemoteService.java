package com.example.josh.amazonbooksexample.model.data.remote;

import com.example.josh.amazonbooksexample.model.Book;
import com.example.josh.amazonbooksexample.utils.NetworkAPI;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RemoteService {

    @GET(NetworkAPI.PATH)
    Observable<List<Book>> getBooks();
}
