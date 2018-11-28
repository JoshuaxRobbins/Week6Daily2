package com.example.josh.amazonbooksexample.ui.booklist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.josh.amazonbooksexample.R;
import com.example.josh.amazonbooksexample.model.Book;
import com.example.josh.amazonbooksexample.model.data.local.AppDatabase;
import com.example.josh.amazonbooksexample.model.data.local.BookDao;
import com.example.josh.amazonbooksexample.model.data.local.LocalDataSource;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {
    public static final String TAG = "_TAG";
    static Context context;
    private RecyclerView rvBooksList;
    List<Book> bookList = new ArrayList<>();
    private BookListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        Book book = new Book();
        book.setTitle("Harry");
        bookList.add(book);


        BookListViewModel viewModel = ViewModelProviders.of(this).get(BookListViewModel.class);

        viewModel.getBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                for (Book book: books) {
                    Log.d(TAG, "onChanged: " + book.toString());

                }
                bindRecyclerView(bookList);
            }

        });
        Log.d(TAG, "onCreate: ");


    }

    public static Context getAppContext(){
        return context;
    }

    private void bindRecyclerView(List<Book> bookList){
        rvBooksList = findViewById(R.id.rvBooksList);
        adapter = new BookListAdapter(bookList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvBooksList.setAdapter(adapter);
        rvBooksList.setLayoutManager(layoutManager);
        Log.d(TAG, "bindRecyclerView: ");
    }
}
