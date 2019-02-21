package com.example.jdominguez.endavalibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DisplayBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_book);

        TextView name = (TextView)findViewById(R.id.textNameView);
        TextView author = (TextView)findViewById(R.id.textAuthorView);
        TextView isbn = (TextView)findViewById(R.id.textIsbnView);
        TextView language = (TextView)findViewById(R.id.textLanguageView);
        TextView publisher = (TextView)findViewById(R.id.textPublisherView);

        name.setText(getIntent().getStringExtra("NAME"));
        author.setText(getIntent().getStringExtra("AUTHOR"));
        isbn.setText(String.valueOf(getIntent().getIntExtra("ISBN", 0)));
        language.setText(getIntent().getStringExtra("LANGUAGE"));
        publisher.setText(getIntent().getStringExtra("PUBLISHER"));

        Toolbar mToolbar = (Toolbar) findViewById(R.id.backButtonToolbar);
        mToolbar.setTitle(getIntent().getStringExtra("NAME"));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_left_solid);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //Finishes current activity
            }
        });
    }
}
