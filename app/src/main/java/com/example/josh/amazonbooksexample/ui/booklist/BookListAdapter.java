package com.example.josh.amazonbooksexample.ui.booklist;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.josh.amazonbooksexample.R;
import com.example.josh.amazonbooksexample.model.Book;
import com.example.josh.amazonbooksexample.ui.viewholder.BookHolder;
import com.example.josh.amazonbooksexample.ui.viewholder.BookImageViewHolder;
import com.example.josh.amazonbooksexample.ui.viewholder.BookViewHolder;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookHolder> {
    public static final String TAG = "_TAG";
    List<Book> bookList;
    int holderType = 0;

    public BookListAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        int itemViewLayout = getItemViewLayout(viewType);
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(itemViewLayout, viewGroup, false);
        BookHolder holder = getViewHolder(viewType,view);

        return holder;
    }

    public BookHolder getViewHolder(int viewType,View view){
        if (viewType == R.layout.item_book_list)
                return new BookImageViewHolder(view);
        else
            return new BookViewHolder(view);
    }

    public int getItemViewLayout(int viewType) {

        if (viewType == 1)
            return R.layout.item_book_list;
        else
            return R.layout.title_book_list;

    }


    @Override
    public void onBindViewHolder(@NonNull BookHolder viewHolder, int position) {
        Book book = bookList.get(position);
        Glide.with(viewHolder.itemView.getContext()).load(book.getImageURL()).into(viewHolder.ivBook);
        if (holderType == 2)
            viewHolder.tvTitle.setText(book.getTitle());
        Log.d(TAG, "onBindViewHolder: ");

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "getItemViewType: ");
        if (bookList.get(position).getTitle().contains("Harry Potter"))
            return 1;
        return 2;


    }
}