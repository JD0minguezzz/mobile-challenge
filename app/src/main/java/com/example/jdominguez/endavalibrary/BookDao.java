package com.example.jdominguez.endavalibrary;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

public interface BookDao {
    @Insert
    void insert(Book book);

    @Query("DELETE FROM book_table WHERE name = :name")
    void deleteBook(String name);

    //Query that allows to search a book by its name...
    @Query("SELECT name, author, isbn, language, publisher FROM book_table WHERE name = :name")
    LiveData<List<Book>> retrieveBookByName(String name);

    //Query that allows to search a book's info...
    @Query("SELECT name, author, isbn, language, publisher FROM book_table")
    Book retrieveBook(String name);

    //@Query("UPDATE book_table SET name ")
}
