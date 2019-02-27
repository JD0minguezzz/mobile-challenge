package com.example.jdominguez.endavalibrary;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void insert(Book book);

    @Query("DELETE FROM book_table WHERE id = :id")
    void deleteBook(int id);

    @Query("DELETE FROM book_table")
    void deleteAll();

    /*@Query("UPDATE FROM book_table")
    void deleteAll();*/

    //Query that allows to search a book by its name...
    /*@Query("SELECT name, author, isbn, language, publisher FROM book_table WHERE name = :name")
    LiveData<List<Book>> retrieveBookByName(String name);*/

    //Query that allows to search a book's info...
    /*@Query("SELECT name, author, isbn, language, publisher FROM book_table")
    LiveData<List<Book>> retrieveBook();*/

    @Query("SELECT * FROM book_table")
    LiveData<List<Book>> retrieveBook();

    /*@Query("SELECT name FROM book_table")
    LiveData<List<Book>> retrieveBook();*/

    @Query("UPDATE book_table SET " +
            "name = :name," +
            "author = :author," +
            "isbn = :isbn," +
            "language = :language," +
            "publisher = :publisher " +
            "WHERE id = :id")
    void updateBook(String name, String author, int isbn, String language, String publisher, int id);
}
