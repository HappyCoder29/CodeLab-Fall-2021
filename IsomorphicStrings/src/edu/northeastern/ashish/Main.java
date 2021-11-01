package edu.northeastern.ashish;

import java.util.HashMap;
//https://leetcode.com/problems/isomorphic-strings/solution/
public class Main {

    public static void main(String[] args) {
        System.out.println(areIsoMorphic("badc", "baba"));
    }

    private static boolean areIsoMorphic(String str1, String str2){

        if(str1.length() != str2.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> reverseMap = new HashMap<>();

        for(int i = 0 ; i < str1.length(); i ++){
            Character ch1 = str1.charAt(i);
            Character ch2 = str2.charAt(i);

            if(!map.containsKey(ch1)){
              if(reverseMap.containsKey(ch2)){
                  return false;
              }
              map.put(ch1 , ch2);
              reverseMap.put(ch2, ch1);
            }else{
                if(map.get(ch1) != ch2 || reverseMap.get(ch2) != ch1 ){
                    return false;
                }
            }
        }

        return true;

    }
}
