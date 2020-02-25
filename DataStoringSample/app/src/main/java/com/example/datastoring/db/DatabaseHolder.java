package com.example.datastoring.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.concurrent.locks.ReentrantLock;

public class DatabaseHolder {

    private final AppSqliteOpenHelper appSqliteOpenHelper;

    private SQLiteDatabase sqLiteDatabase;

    private int databaseOpenCloseBalance;

    private ReentrantLock reentrantLock = new ReentrantLock();

    public DatabaseHolder(@NonNull final Context context) {
        appSqliteOpenHelper = new AppSqliteOpenHelper(context);
    }

    public SQLiteDatabase open() {
        try {
            reentrantLock.lock();
            if (databaseOpenCloseBalance == 0) {
                sqLiteDatabase = appSqliteOpenHelper.getWritableDatabase();
            }

            ++databaseOpenCloseBalance;

            return sqLiteDatabase;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void close() {
        try {
            reentrantLock.lock();
            --databaseOpenCloseBalance;

            if (databaseOpenCloseBalance == 0) {
                sqLiteDatabase.close();
                sqLiteDatabase = null;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
