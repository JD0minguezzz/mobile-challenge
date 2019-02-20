package com.example.jdominguez.endavalibrary;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
//import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private BookViewModel mBookViewModel;
    public static final int NEW_BOOK_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final BookListAdapter adapter = new BookListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.backButtonToolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_left_solid);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //Finishes current activity
            }
        });

        mBookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);

        mBookViewModel.getAllBooks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable final List<Book> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });

        //FloatingActionButton fab = findViewById(R.id.fab);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //data.getStringExtra(NewBookActivity.NAME)

        if (requestCode == NEW_BOOK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            Book book = new Book();
            book.setId((int) Math.floor(Math.random() * 1000));
            book.setName(bundle.getString("NAME"));
            book.setAuthor(bundle.getString("AUTHOR"));
            book.setIsbn(bundle.getInt("ISBN"));
            book.setLanguage(bundle.getString("LANGUAGE"));
            book.setPublisher(bundle.getString("PUBLISHER"));
            mBookViewModel.insert(book);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void addNewBook(View view) {
        Intent intent = new Intent(this, NewBookActivity.class);
        startActivityForResult(intent, NEW_BOOK_ACTIVITY_REQUEST_CODE);
    }

}