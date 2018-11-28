package com.example.josh.amazonbooksexample.model.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.josh.amazonbooksexample.model.Book;
import com.example.josh.amazonbooksexample.model.data.local.AppDatabase;
import com.example.josh.amazonbooksexample.model.data.local.LocalDataSource;
import com.example.josh.amazonbooksexample.model.data.remote.RemoteDataSource;
import com.example.josh.amazonbooksexample.ui.booklist.BookListActivity;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookRepository {
    MutableLiveData<List<Book>> listLiveData;

    RemoteDataSource remoteDataSource;
    LocalDataSource localDataSource;
    SharedPreferences prefs;
    final int fiveMinutes = 1000 * 60 * 5;
    public static final String TAG = "_TAG";

    public BookRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        listLiveData = new MutableLiveData<>();
        prefs = BookListActivity.getAppContext().getSharedPreferences("com.example.josh.amazonbooksexample",Context.MODE_PRIVATE);
    }

    public LiveData<List<Book>> getBooks(){
        if(localOrRemote()){
            remoteDataSource.getBooks(new DataCallback() {
                @Override
                public void onSuccess(List<Book> bookList) {

                }

                @Override
                public void onFailure(String error) {

                }
            });
            localDataSource.removeBooks();
            listLiveData.setValue(localDataSource.getBooks());
            Log.d(TAG, "getBooks: ");
        }
        else{
            remoteDataSource.getBooks(new DataCallback() {
                @Override
                public void onSuccess(List<Book> bookList) {
                    listLiveData.setValue(bookList);
                    localDataSource.storeAllBooks(bookList);
                    Date time = Calendar.getInstance().getTime();
                    prefs.edit().putLong("lastupdate",time.getTime()).apply();
                    Log.d(TAG, "onSuccess: " + time.toString());
                }

                @Override
                public void onFailure(String error) {

                }
            });
        }


        return listLiveData;
    }

    private boolean localOrRemote() {

        long lastUpdate = prefs.getLong("lastupdate",0);
        Date lastDateTime = new Date(lastUpdate);
        Date currentDateTime = Calendar.getInstance().getTime();
        Log.d(TAG, "localOrRemote: " + (currentDateTime.getTime() - lastDateTime.getTime()) + "  " + lastDateTime);
        if(lastUpdate == 0 || (currentDateTime.getTime() - lastDateTime.getTime()) > fiveMinutes){
            return false;
        }
        return true;
    }
}
