package com.test;

public class Anagram {
    public static void anagram(String prefix, String suffix) {
        String newPrefix, newSuffix;
        int numOfChars = suffix.length();
        if (numOfChars == 1) {
            System.out.println(prefix + suffix);
        } else {
            for (int i = 1; i <= numOfChars; i++) {
                newSuffix = suffix.substring(1, numOfChars);
                newPrefix = prefix + suffix.charAt(0);
                anagram(newPrefix, newSuffix);
                // recursive call
                // rotate left to create a rearranged suffix
                suffix = newSuffix + suffix.charAt(0);
            }
        }
    }
    public static void main(String[] args) {
        Anagram.anagram("", "kunal");
    }
}
