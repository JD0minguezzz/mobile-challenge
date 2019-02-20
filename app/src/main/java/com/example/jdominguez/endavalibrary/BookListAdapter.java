package com.example.jdominguez.endavalibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {

    class BookViewHolder extends RecyclerView.ViewHolder {

        private final TextView bookItemView;

        private BookViewHolder(View itemView) {
            super(itemView);
            bookItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Book> books; // Cached copy of words

    BookListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        if (books != null) {
            Book current = books.get(position);
            holder.bookItemView.setText(current.getName()); //Retrieves only the name of the book
        } else {
            // Covers the case of data not being ready yet.
            holder.bookItemView.setText("No Book");
        }
    }

    void setWords(List<Book> words){
        books = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (books != null)
            return books.size();
        else return 0;
    }
}
