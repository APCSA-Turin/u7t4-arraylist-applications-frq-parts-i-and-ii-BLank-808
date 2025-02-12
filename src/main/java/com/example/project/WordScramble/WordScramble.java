package com.example.project.WordScramble;
import java.util.ArrayList;
import java.util.Arrays;
public class WordScramble {
  /** Scrambles a given word.
   *
   *  @param word  the word to be scrambled
   *  @return  the scrambled word (possibly equal to word)
   *
   *  Precondition: word is either an empty string or contains only uppercase letters.
   *  Postcondition: the string returned was created from word as follows:
   *  - the word was scrambled, beginning at the first letter and continuing from left to right
   *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   *  - letters were swapped at most once
   */
  public static String scrambleWord(String word) {
    boolean prevA=false;
    String scambled="";
      for (int i = 0; i < word.length(); i++) {
        if(word.substring(i, i+1).equals("A")){
          prevA=true;
          if (i+2<=word.length()&&word.substring(i, i+1).equals(word.substring(i+1, i+2))) {
            scambled+="A";
            i++;
          }
          if(i==word.length()-1){
            scambled+="A";
          }
          continue;
        }
        if(!prevA){
          scambled+=word.substring(i, i+1); 
        }else{
          prevA=false;
          scambled+=word.substring(i, i+1);
          scambled+= word.substring(i-1, i);
        }
      }
      return scambled;
  }

  /** Modifies wordList by replacing each word with its scrambled
   *  version, removing any words that are unchanged as a result of scrambling.
   *
   *  @param wordList the list of words
   *
   *  Precondition: wordList contains only non-null objects
   *  Postcondition:
   *  - all words unchanged by scrambling have been removed from wordList
   *  - each of the remaining words has been replaced by its scrambled version
   *  - the relative ordering of the entries in wordList is the same as it was
   *    before the method was called
   */
  public static ArrayList<String> scrambleOrRemove(ArrayList<String> wordList) {
    String og="";
    for (int i = 0; i <wordList.size(); i++) {
      og=wordList.get(i)+"";
      wordList.set(i,scrambleWord(og));
      if(wordList.get(i).equals(og)){
        wordList.remove(i);
        i--;
      }
    }
      return wordList;
  }

  public static void main(String[] args) {
        ArrayList<String> testWordList = new ArrayList<String>(Arrays.asList("TAN", "ABRACADABRA", "WHOA", "APPLE", "EGGS"));
        testWordList = WordScramble.scrambleOrRemove(testWordList);
  }
}
