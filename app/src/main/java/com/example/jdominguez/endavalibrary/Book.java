package com.example.jdominguez.endavalibrary;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "book_table")
public class Book {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "isbn")
    private int isbn;

    @ColumnInfo(name = "language")
    private String language;

    @ColumnInfo(name = "publisher")
    private String publisher;
}
