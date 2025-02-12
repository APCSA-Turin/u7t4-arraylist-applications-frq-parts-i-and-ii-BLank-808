package com.example.project.Delimiter;
import java.util.ArrayList;

public class Delimiters {
    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> Dels=new ArrayList<String>();
        for (String str : tokens) {
            if(str.equals(openDel)|| str.equals(closeDel)){
                Dels.add(str);
            }
        }
        return Dels;
    }
    

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters) {
        int closed=0;
        int open=0;
        for (String iterable_element : delimiters) {
            if(iterable_element.equals(closeDel)){
                closed++;
            }else if(iterable_element.equals(openDel)){
                open++;
            } 
            if(closed>open){return false;}

        }
        if(open==closed){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Delimiters delimitersEx3 = new Delimiters("<sup>", "</sup>");
        String[] tokens4 = {"<sup>", "</sup>", "</sup>", "<sup>"};
        ArrayList<String> delList2 = delimitersEx3.getDelimitersList(tokens4);
        boolean res2 = delimitersEx3.isBalanced(delList2);
    System.out.println(res2);
    }
}