package com.torres;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TORRES.DB";

    public static final String ACCOUNT_TABLE_NAME = "ACCOUNT";
    public static final String ACCOUNT_ID = "ID";
    public static final String ACCOUNT_ACCOUNT_ID = "ACCOUNT_ID";
    public static final String ACCOUNT_EMAIL = "EMAIL";
    public static final String ACCOUNT_PASSWORD = "PASSWORD";
    public static final String ACCOUNT_ACCESS_PIN = "ACCESS_PIN";
    public static final String ACCOUNT_DATE_CREATED = "DATE_CREATED";
    public static final String ACCOUNT_DATE_UPDATED = "DATE_UPDATED";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                        + ACCOUNT_TABLE_NAME
                            + "("
                                + ACCOUNT_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + ACCOUNT_ACCOUNT_ID    + " TEXT NOT NULL UNIQUE,"
                                + ACCOUNT_EMAIL         + " TEXT NOT NULL UNIQUE,"
                                + ACCOUNT_PASSWORD      + " TEXT NOT NULL,"
                                + ACCOUNT_ACCESS_PIN    + " TEXT,"
                                + ACCOUNT_DATE_CREATED  + " TEXT NOT NULL,"
                                + ACCOUNT_DATE_UPDATED  + " TEXT NOT NULL"
                            + ")"
                    );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ACCOUNT_TABLE_NAME);
        onCreate(db);
    }
}
