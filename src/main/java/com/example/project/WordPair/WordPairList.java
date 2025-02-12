package com.example.project.WordPair;

import java.util.ArrayList;

public class WordPairList {
    private ArrayList<WordPair> allPairs;

    public WordPairList(String[] words) {
        allPairs= new ArrayList<>();
        for (int index = 0; index < (words.length-1); index++) {
            for(int i=index+1; i<words.length; i++){
                allPairs.add(new WordPair(words[index], words[i]));
            }
        }
    }

    // The method below was added for testing;
    // it was not part of the original FRQ
    public ArrayList<WordPair> getAllPairs() {
        return allPairs;
    }

    public int numMatches() {
        int c=0;
        for (WordPair e : allPairs) {
            if (e.getFirst().equals(e.getSecond())) {
            c++;
            }  
        }
        return c;
    }

    // The method below was added for testing;
    // it was not part of the original FRQ
    public String toString() {
        return allPairs.toString();
    }

    public static void main(String[] args) {
        String[] wordNums = {"one", "two", "three"};
        WordPairList exampleOne = new WordPairList(wordNums);
    }
}
