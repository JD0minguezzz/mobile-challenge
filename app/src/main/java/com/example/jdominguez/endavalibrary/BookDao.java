package com.example.jdominguez.endavalibrary;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

public interface BookDao {
    @Insert
    void insert(Book book);

    @Query("DELETE FROM book_table WHERE name = :name")
    void deleteBook(String name);

    @Query("SELECT name, author, isbn, language, publisher FROM book_table WHERE name = :name")
    Book retrieveBook(String name);

    //@Query("UPDATE book_table SET name ")
}
