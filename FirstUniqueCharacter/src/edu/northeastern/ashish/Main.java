package edu.northeastern.ashish;

import java.util.HashMap;
//https://leetcode.com/problems/first-unique-character-in-a-string/
public class Main {

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("aabb"));
    }

    private static int firstUniqueChar(String str){
        if(str == null || str.length() == 0){
            return -1;
        }
        if(str.length() == 1){
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i= 0 ; i < str.length(); i ++){
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }
}
