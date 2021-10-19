package edu.northeastern.ashish;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class Main {

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<List<String> > anagrams = groupAnagramsPrime(arr);
        System.out.println();
    }

    private static ArrayList<ArrayList<String>> groupAnagrams(String[] arr){

        ArrayList<ArrayList<String>> listAnagrams = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : arr) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);// if we do count sort here we can get O(n)

            String anagram = String.valueOf(ch);
            if( !map.containsKey(anagram) ){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(anagram,  list);
            }else{
                ArrayList<String> list = map.get(anagram);
                list.add(str);
                map.put(anagram, list);
            }
        }

        for ( Map.Entry<String, ArrayList<String>> entry : map.entrySet() ) {
            listAnagrams.add(entry.getValue());
        }

        return listAnagrams;

    }



    public static List< List<String> > groupAnagramsPrime(String[] strs) {
        int[] primes ={ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101};
        Map<Long,List<String>> map = new HashMap<>();
        for (String str : strs) {
            long product = calculatePrimeProduct(str, primes);
            if (map.containsKey(product)) {
                map.get(product).add(str);
            } else {
                map.put(product, new ArrayList<>());
                map.get(product).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
    public static long calculatePrimeProduct(String s, int[] primes){
        long prod = 1L;
        for(int i=0;i<s.length();i++){
            prod = prod * primes[s.charAt(i) - 'a'];
        }
        return prod;
    }
}
