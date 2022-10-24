package com.example.la2.utils;

public class TextCounter {
    public static int getCharsCount(String phrase) {
        return phrase.length();
    }
    public static int getWordsCount(String phrase) {
        String[] wordsArray = phrase.split("[ ,.]");
        return wordsArray.length;
    }
}