package edu.northeastern.ashish;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("bcabc"));
    }

    private static String removeDuplicates(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        String englishLetters = "abcdefghijklmnopqrstuvwxyz";
        for (Character ch : englishLetters.toCharArray()) {
            map.put(ch, 0);
        }
        for (Character ch : str.toCharArray()) {
            if(map.get(ch)  == 0 ){
                map.put(ch, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();


    }
}
