package com.example.jdominguez.endavalibrary;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class BookRepository {

    private BookDao bookDao;
    private LiveData<List<Book>> allBooks;

    BookRepository(Application application) {
        BookDatabase db = BookDatabase.getDatabase(application);
        bookDao = db.bookDao();
        allBooks = bookDao.retrieveBook();
    }

    LiveData<List<Book>> getAllBooks() {
        return allBooks;
    }

    public void insert (Book book) {
        new insertAsyncTask(bookDao).execute(book);
    }

    public void deleteBook (String bookName) { new deleteAsyncTask(bookDao).execute(bookName); }

    private static class insertAsyncTask extends AsyncTask<Book, Void, Void> {

        private BookDao asyncTaskDao;

        insertAsyncTask(BookDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Book... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<String, Void, Void> {

        private BookDao asyncTaskDao;

        deleteAsyncTask(BookDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            asyncTaskDao.deleteBook(params[0]);
            return null;
        }
    }
}
