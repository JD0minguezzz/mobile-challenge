package com.example.jdominguez.endavalibrary;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PopActivity extends AppCompatActivity {

    private BookViewModel mBookViewModel;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        //params.x = 0;
        //params.y = -20;

        getWindow().setAttributes(params);

        TextView name = (TextView)findViewById(R.id.name);
        TextView author = (TextView)findViewById(R.id.author);
        TextView isbn = (TextView)findViewById(R.id.isbn);
        TextView language = (TextView)findViewById(R.id.language);
        TextView publisher = (TextView)findViewById(R.id.publisher);
        ImageButton closeButton = findViewById(R.id.closeButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        //ImageView bookCover = (ImageView)findViewById(R.id.bookCover);

        name.setText(getIntent().getStringExtra("NAME"));
        author.setText(getIntent().getStringExtra("AUTHOR"));
        isbn.setText(String.valueOf(getIntent().getIntExtra("ISBN", 0)));
        language.setText(getIntent().getStringExtra("LANGUAGE"));
        publisher.setText(getIntent().getStringExtra("PUBLISHER"));


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //Finishes current activity
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            /*@Override
            public void onClick(View view) {
                Intent intent = new Intent(PopActivity.this, ConfirmationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("NAME", getIntent().getStringExtra("NAME"));
                intent.putExtras(bundle);
                startActivity(intent);
            }*/
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PopActivity.this);
                //AlertDialog warningDialog = builder.create();
                LayoutInflater inflater = getLayoutInflater();
                View warningDialogView = inflater.inflate(R.layout.activity_confirmation, null);

                builder.setView(warningDialogView);
                //warningDialog.show();

                /*int width = getResources().getDisplayMetrics().widthPixels;
                int height = getResources().getDisplayMetrics().heightPixels;*/

                Button confirmDeletionButton = warningDialogView.findViewById(R.id.confirmDeletionButton);
                Button abortDeletionButton = warningDialogView.findViewById(R.id.abortDeletionButton);
                TextView name = warningDialogView.findViewById(R.id.warningText);
                name.setText("¿Are you sure you want to delete " + getIntent().getStringExtra("NAME") + "?");

                int width = getResources().getDisplayMetrics().widthPixels;
                int height = getResources().getDisplayMetrics().heightPixels;

                AlertDialog warningDialog = builder.create();
                warningDialog.show();
                warningDialog.getWindow().setLayout((int)(width*.8), (int)(height*.3));

                //confirmDeletionButton.setOnClickListener();

                mBookViewModel = ViewModelProviders.of(PopActivity.this).get(BookViewModel.class);

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
        });


    }
}
