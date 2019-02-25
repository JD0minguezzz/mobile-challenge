package com.example.jdominguez.endavalibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PopActivity extends AppCompatActivity {

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
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PopActivity.this, ConfirmationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("NAME", getIntent().getStringExtra("NAME"));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
