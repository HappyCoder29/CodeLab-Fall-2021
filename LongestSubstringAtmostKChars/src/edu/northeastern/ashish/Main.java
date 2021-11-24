package edu.northeastern.ashish;

import java.util.HashMap;
//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class Main {

    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(longestSubStrWithAtmostKChars(str, 4));
    }

    private static String longestSubStrWithAtmostKChars(String str, int k) {
        if (str == null || str.length() == 1 ) {
            return str;
        }
        if(k <=0){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int maxLength = 0;
        String maxString = "";
        // Check while start and end is less than the str
        while (start != str.length() - 1 && end <=  str.length() - 1) {

            Character ch = str.charAt(end);

            if (map.containsKey(str.charAt(end))) {
                // If the value is already there we would increment the count of that char in hash map
                // and update the max string if necessary and continue
                map.put(ch , map.getOrDefault(ch, 0) + 1);
                maxString = getMaxString(str, start, end +1, maxLength, maxString);
                maxLength = maxString.length();
                end++;
                continue;
            }
            // This char has not occured before, so we add this value in the hash map
            map.put(ch , 1);
            end ++;



            // if the map size had exceeded keep mopving start pointer so that the map size becomes
            // less than K
            if (map.size() > k) {
                while (map.size() > k) {
                    if (map.get(str.charAt(start)) == 1) {
                        map.remove(str.charAt(start));
                    } else {
                        map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
                    }
                    start++;
                }
            }

            // Update max string if necessary
            maxString = getMaxString(str, start, end, maxLength, maxString);
            maxLength = maxString.length();

        }
        return maxString;
    }

    private static String getMaxString(String str, int start, int end, int maxLength, String maxString){
        if (end - start >= maxLength) {
            maxString = str.substring(start, end);
        }
        return maxString;
    }
}

