package com.gmail.michelegozzi.flashcards;

/**
 * Created by mgozzi on 5/7/2017.
 */

public class Helpers {
    public static <T extends Enum<?>> T lookup(Class<T> enumeration,
                                               String search) {
        for (T each : enumeration.getEnumConstants()) {
            if (each.name().compareToIgnoreCase(search) == 0) {
                return each;
            }
        }
        return null;
    }
}
