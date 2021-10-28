package edu.northeastern.ashish;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/


public class Main {

    public static void main(String[] args) {
        System.out.println(longestSubStringNoRepeat("pwwkew"));

    }


    private static String longestSubStringNoRepeat(String str){
        if(str.length() <= 1){
            return str;
        }
        HashSet<Character> set = new HashSet<>();

        int start = 0;
        int maxLength = 0;
        String longestSubstring = "";

        for(int current = 0 ; current < str.length(); current ++){
            if( !set.contains(str.charAt(current) )){
                set.add(str.charAt(current));
                // find the max string and max length here
                if(maxLength <  current - start +1 ){
                    maxLength = current - start +1;
                    longestSubstring = str.substring(start, current+1);
                }
            }else{
                while( set.contains(str.charAt(current)) ) {
                    set.remove(str.charAt(start));
                    start ++;
                }
                set.add(str.charAt(current));
            }
        }
        return longestSubstring;
    }

}
