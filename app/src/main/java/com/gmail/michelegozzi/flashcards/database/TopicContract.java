package com.gmail.michelegozzi.flashcards.database;

import android.provider.BaseColumns;

/**
 * Created by mgozzi on 10/27/2016.
 */



public final class TopicContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private TopicContract() {}

    /* Inner class that defines the table contents */
    public static class TopicEntry implements BaseColumns {
        public static final String TABLE_NAME = "topic";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_PAYLOAD = "payload";
    }
}