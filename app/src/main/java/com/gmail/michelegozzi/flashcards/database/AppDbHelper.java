package com.gmail.michelegozzi.flashcards.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mgozzi on 10/27/2016.
 */


public class AppDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "OpenFlashCards.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_TOPICS =
            "CREATE TABLE " + TopicContract.TopicEntry.TABLE_NAME + " (" +
                    TopicContract.TopicEntry._ID + " INTEGER PRIMARY KEY," +
                    TopicContract.TopicEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    TopicContract.TopicEntry.COLUMN_NAME_PAYLOAD + TEXT_TYPE + " )";

    private static final String SQL_DELETE_TOPICS =
            "DROP TABLE IF EXISTS " + TopicContract.TopicEntry.TABLE_NAME;

    private static final String SQL_CREATE_IDENTITY =
            "CREATE TABLE " + IdentityContract.IdentityEntry.TABLE_NAME + " (" +
                    IdentityContract.IdentityEntry._ID + " INTEGER PRIMARY KEY," +
                    IdentityContract.IdentityEntry.COLUMN_NAME_USER_ID + TEXT_TYPE + COMMA_SEP +
                    IdentityContract.IdentityEntry.COLUMN_NAME_APPLICATION_ID + TEXT_TYPE + COMMA_SEP +
                    IdentityContract.IdentityEntry.COLUMN_NAME_TOKEN + TEXT_TYPE + COMMA_SEP +
                    IdentityContract.IdentityEntry.COLUMN_NAME_TYPE + TEXT_TYPE + " )";

    private static final String SQL_DELETE_IDENTITY =
            "DROP TABLE IF EXISTS " + IdentityContract.IdentityEntry.TABLE_NAME;

    public AppDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TOPICS);
        db.execSQL(SQL_CREATE_IDENTITY);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_TOPICS);
        db.execSQL(SQL_DELETE_IDENTITY);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}