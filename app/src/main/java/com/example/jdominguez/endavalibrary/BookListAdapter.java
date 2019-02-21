package com.example.jdominguez.endavalibrary;

import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {

    class BookViewHolder extends RecyclerView.ViewHolder {

        private final TextView bookNameView;
        private final TextView bookAuthorView;
        private final TextView bookIsbnView;
        private final TextView bookLanguageView;
        private final TextView bookPublisherView;

        private BookViewHolder(View itemView) {
            super(itemView);
            bookNameView = itemView.findViewById(R.id.textNameView);
            bookAuthorView = itemView.findViewById(R.id.textAuthorView);
            bookIsbnView = itemView.findViewById(R.id.textIsbnView);
            bookLanguageView = itemView.findViewById(R.id.textLanguageView);
            bookPublisherView = itemView.findViewById(R.id.textPublisherView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Book> books; // Cached copy of books

    BookListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    /*private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) { itemClicked(v); }
    };*/

    /*private void itemClicked(View v) {
        Intent intent = new Intent(BookListActivity.this, );
        startActivity(intent);
    }*/

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        //itemView.setOnClickListener(mOnClickListener);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        if (books != null) {
            Book current = books.get(position);
            holder.bookNameView.setText(current.getName()); //Retrieves only the name of the book
            holder.bookAuthorView.setText(current.getAuthor());
            holder.bookIsbnView.setText(String.valueOf(current.getIsbn()));
            holder.bookLanguageView.setText(current.getLanguage());
            holder.bookPublisherView.setText(current.getPublisher());
        } else {
            // Covers the case of data not being ready yet.
            holder.bookNameView.setText("Cool Book");
            holder.bookAuthorView.setText("Jane Doe");
            holder.bookIsbnView.setText("0000");
            holder.bookLanguageView.setText("Klingon");
            holder.bookPublisherView.setText("Detective Comics");
        }
    }

    void setBooks(List<Book> words){
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
