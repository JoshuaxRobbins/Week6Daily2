package com.example.josh.amazonbooksexample.ui.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josh.amazonbooksexample.R;



public class BookViewHolder extends BookHolder {

    TextView tvTitle;
    ImageView ivBook;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        ivBook = itemView.findViewById(R.id.ivBook);
    }
}
