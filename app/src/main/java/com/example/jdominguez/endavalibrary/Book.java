package com.example.jdominguez.endavalibrary;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "book_table")
public class Book {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int bookId;


}
