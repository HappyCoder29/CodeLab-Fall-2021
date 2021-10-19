package edu.northeastern.ashish;

// 443. String Compression
// Leet code question https://leetcode.com/problems/string-compression/
// I am not returning count I am just returning compressed array

import java.util.*;

public class Main {

    public static void main(String[] args) {
        char[] arr =  {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(stringCompression(arr));

        rearrange("baacc");

    }

    private static String stringCompression(char[] arr){
        char lastChar = arr[0];
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i = 1; i < arr.length; i ++){
            // If the last char is same as the previous then just increment count\
            // otherwise check if count == 1 in that case just get last char
            // else add last char and 1
            if(arr[i] == lastChar){
                count++;
            }else{
                if(count == 1){
                    sb.append(lastChar);
                }else{

                    sb.append( Character.toString(lastChar) + count );
                    count =1;
                }
            }
            lastChar = arr[i];
        }

        if(count == 1){
            sb.append(lastChar);
        }else{
            sb.append(Character.toString(lastChar) + count );
        }
        return  sb.toString();
    }


    public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            return new ArrayList();
        }
        HashMap<String, ArrayList<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }else{
                ans.get(key).add(s);
            }
        }
        return new ArrayList(ans.values());
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    private static void rearrange(String str){
        char[] arr = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : arr) {
           if(!map.containsKey(ch))  {
               map.put(ch, 1);
           }
           else{
               map.put(ch, map.get(ch) + 1);
           }
        }
        map = sortByValue(map);

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            System.out.println( entry.getKey() + " , " + entry.getValue());
        }

    }

    //sort elements by values
    private static HashMap<Character, Integer> sortByValue( HashMap<Character, Integer> map) {
        //convert HashMap into List
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        return map;
    }
}
