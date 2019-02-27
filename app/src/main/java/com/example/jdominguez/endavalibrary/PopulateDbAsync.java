package com.example.jdominguez.endavalibrary;

import android.os.AsyncTask;

public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final BookDao mDao;

    PopulateDbAsync(BookDatabase db) {
        mDao = db.bookDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        /*mDao.deleteAll();
        Book book = new Book();
        book.setId(1);
        book.setName("Cien Años de Soledad");
        book.setAuthor("Gabriel García Marquez");
        book.setIsbn(1234);
        book.setLanguage("Spanish");
        book.setPublisher("Norma");
        mDao.insert(book);
        book = new Book();
        book.setId(2);
        book.setName("Delirio");
        book.setAuthor("Laura Restrepo");
        book.setIsbn(5678);
        book.setLanguage("Spanish");
        book.setPublisher("Penguin");
        mDao.insert(book);*/
        return null;
    }
}
