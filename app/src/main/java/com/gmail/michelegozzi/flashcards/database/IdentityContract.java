package com.gmail.michelegozzi.flashcards.database;

import android.provider.BaseColumns;

/**
 * Created by mgozzi on 10/27/2016.
 */

public final class IdentityContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private IdentityContract() {}

    /* Inner class that defines the table contents */
    public static class IdentityEntry implements BaseColumns {
        public static final String TABLE_NAME = "identity";
        public static final String COLUMN_NAME_USER_ID = "userid";
        public static final String COLUMN_NAME_APPLICATION_ID = "appid";
        public static final String COLUMN_NAME_TOKEN = "token";
        public static final String COLUMN_NAME_TYPE = "type";
    }
}
