package com.gmail.michelegozzi.flashcards;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gmail.michelegozzi.flashcards.database.AppDbHelper;
import com.gmail.michelegozzi.flashcards.database.IdentityContract;

/**
 * Created by mgozzi on 10/28/2016.
 */

public class Identity {

    private String userId;
    private String applicationId;
    private String token;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean hasValidToken() {
        return this.token != null && this.token.length() > 0;
    }

    private Identity(){}

    public void save(Context appContext) {
        AppDbHelper mDbHelper = new AppDbHelper(appContext);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(IdentityContract.IdentityEntry.COLUMN_NAME_USER_ID, this.getUserId());
        values.put(IdentityContract.IdentityEntry.COLUMN_NAME_APPLICATION_ID, this.getApplicationId());
        values.put(IdentityContract.IdentityEntry.COLUMN_NAME_TOKEN, this.getToken());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(IdentityContract.IdentityEntry.TABLE_NAME, null, values);
    }

    public void load(Context appContext) {
        AppDbHelper mDbHelper = new AppDbHelper(appContext);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                IdentityContract.IdentityEntry._ID,
                IdentityContract.IdentityEntry.COLUMN_NAME_USER_ID,
                IdentityContract.IdentityEntry.COLUMN_NAME_APPLICATION_ID,
                IdentityContract.IdentityEntry.COLUMN_NAME_TOKEN
        };

        // Filter results WHERE "title" = 'My Title'
        //String selection = IdentityContract.IdentityEntry.COLUMN_NAME_TITLE + " = ?";
        //String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
        //String sortOrder =
        //IdentityContract.IdentityEntry.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor cursor = db.query(
                IdentityContract.IdentityEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null, //selection,                                // The columns for the WHERE clause
                null, //selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null //sortOrder                                 // The sort order
        );

        boolean hasElements = cursor.moveToFirst();

        if (hasElements) {
            this.setUserId(cursor.getString(cursor.getColumnIndexOrThrow(IdentityContract.IdentityEntry.COLUMN_NAME_USER_ID)));
            this.setApplicationId(cursor.getString(cursor.getColumnIndexOrThrow(IdentityContract.IdentityEntry.COLUMN_NAME_APPLICATION_ID)));
            this.setToken(cursor.getString(cursor.getColumnIndexOrThrow(IdentityContract.IdentityEntry.COLUMN_NAME_TOKEN)));
        }
    }

    private static class IdentityHelper{
        private static final Identity INSTANCE = new Identity();
    }

    public static Identity getInstance(){
        return IdentityHelper.INSTANCE;
    }


}
