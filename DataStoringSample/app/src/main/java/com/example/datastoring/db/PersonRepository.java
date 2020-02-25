package com.example.datastoring.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private DatabaseHolder databaseHolder;

    public PersonRepository(@NonNull final DatabaseHolder databaseHolder) {
        this.databaseHolder = databaseHolder;
    }

    public void create(@NonNull final Person person) {
        try {
            SQLiteDatabase database = databaseHolder.open();

            ContentValues contentValues = new ContentValues();
            contentValues.put(PersonContract.Columns.NAME, person.getName());

            database.insert(PersonContract.TABLE_NAME, null, contentValues);
        } finally {
            databaseHolder.close();
        }
    }

    public List<Person> loadAll() {
        List<Person> personList = new ArrayList<>();
        Cursor cursor = null;
        try {
            SQLiteDatabase database = databaseHolder.open();

            cursor = database.query(
                    PersonContract.TABLE_NAME,
                    new String[] {PersonContract.Columns._ID, PersonContract.Columns.NAME},
                    null,
                    null,
                    null,
                    null,
                    null
            );

            while (cursor.moveToNext()) {
                Person person = new Person();
                person.setId(cursor.getLong(cursor.getColumnIndex(PersonContract.Columns._ID)));
                person.setName(cursor.getString(cursor.getColumnIndex(PersonContract.Columns.NAME)));
                personList.add(person);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            databaseHolder.close();
        }

        return personList;
    }
}
