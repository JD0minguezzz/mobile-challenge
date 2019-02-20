package com.example.jdominguez.endavalibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {

    public abstract BookDao bookDao();

    private static volatile BookDatabase INSTANCE;

    static BookDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        BookDatabase.class, "book_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
