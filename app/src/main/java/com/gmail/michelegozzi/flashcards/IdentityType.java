package com.gmail.michelegozzi.flashcards;

/**
 * Created by mgozzi on 11/2/2016.
 */

/*
    public enum IdentityType {
        Api("api"),
        Facebook("facebook");

        private String value;

        IdentityType(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }
    }
    */

public enum IdentityType {
    Api,
    Facebook;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}


