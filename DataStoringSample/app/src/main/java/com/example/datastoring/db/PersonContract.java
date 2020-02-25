package com.example.datastoring.db;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

public class PersonContract {

    public static final String TABLE_NAME = "person_table";

    public interface Columns extends BaseColumns {

        String NAME = "name";
    }

    private PersonContract() {
        // Утилитный класс
    }

    public static void createTable(@NonNull final SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME
                        + " ( "
                        + Columns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + Columns.NAME + " TEXT NOT NULL"
                        + " );"
        );
    }
}
