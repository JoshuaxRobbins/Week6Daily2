package com.example.josh.amazonbooksexample.ui.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josh.amazonbooksexample.R;

public class BookImageViewHolder extends BookHolder {

    ImageView ivBook;

    public BookImageViewHolder(@NonNull View itemView) {
        super(itemView);
        ivBook = itemView.findViewById(R.id.ivBook);
    }
}
