package com.example.jdominguez.endavalibrary;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    /*BookDatabase db = new BookDatabase() {
    }
    private final BookDao mDao;*/

    private BookViewModel mBookViewModel;

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_confirmation);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.7), (int)(height*.2));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        //params.x = 0;
        //params.y = -20;

        getWindow().setAttributes(params);

        Button confirmDeletionButton = (Button)findViewById(R.id.confirmDeletionButton);
        Button abortDeletionButton = (Button)findViewById(R.id.abortDeletionButton);
        TextView name = (TextView)findViewById(R.id.warningText);
        name.setText("¿Are you sure you want to delete " + getIntent().getStringExtra("NAME") + "?");

        //confirmDeletionButton.setOnClickListener();

        mBookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);

        confirmDeletionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBookViewModel.deleteBook(getIntent().getStringExtra("NAME"));
                finish();
            }
        });

        abortDeletionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
