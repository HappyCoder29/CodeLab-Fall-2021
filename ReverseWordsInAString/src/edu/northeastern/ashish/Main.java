package edu.northeastern.ashish;
//https://leetcode.com/problems/reverse-words-in-a-string/
public class Main {

    public static void main(String[] args) {
        String str = "My Name is Ashish. The sky is blue";
        System.out.println( reverseWords1(str) );
    }


    public static String reverseWords1(String s) {

        StringBuilder sb = new StringBuilder();

        String[] S= s.trim().split("\\s+");

        // start from right of S
        for(int i = S.length-1; i >=0; i--){
            sb.append(S[i] + " ");
        }

        // if not using .trim() at the end there would be a empty space
        return sb.toString().trim();
    }

}
