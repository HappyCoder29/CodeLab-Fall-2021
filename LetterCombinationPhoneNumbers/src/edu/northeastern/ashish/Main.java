package edu.northeastern.ashish;

import java.util.Arrays;
import java.util.HashMap;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Main {

    public static void main(String[] args) {
        printCombinationsPhone("23");
    }

    private static void printCombinationsPhone(String phoneNumber){

        int[] result = new int[phoneNumber.length()];
        int current = 0;
        printCombinationsPhone(result, current, phoneNumber);
    }

    private static void printCombinationsPhone(int[] result, int current, String phoneNumber){

        if(current == result.length){
          //  System.out.println(Arrays.toString(result));
            printCombinations(result, phoneNumber);
            return;
        }

        int m = getNumOfTimesRecurse(phoneNumber.charAt(current));

        if(m == -1){
            // this is the case if the value is 1 or 0
            if(phoneNumber.charAt(current) == '1' || phoneNumber.charAt(current) == '0'){
                result[current] = Integer.MIN_VALUE;
                printCombinationsPhone(result, current+1, phoneNumber);
            }
        }else{
            for(int i = 0 ; i < m ; i ++){
                result[current] = i;
                printCombinationsPhone(result, current+1, phoneNumber);
            }
        }
    }

    private static void printCombinations(int[] result, String phoneNumber) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");


        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < result.length; i ++){
            String ch =  Character.toString(phoneNumber.charAt(i));
            if(ch.compareToIgnoreCase("0") == 0 || ch.compareToIgnoreCase("1") == 0 ){
               sb.append(ch);
               continue;
            }
            Integer val = Integer.parseInt(Character.toString(phoneNumber.charAt(i)));
            String str = map.get(val);
            sb.append( str.charAt(result[i] ) );
        }
        System.out.println(sb);

    }

    private static int getNumOfTimesRecurse(char ch){
        String st = Character.toString(ch);
        int val = Integer.parseInt(st);

        if((val >=2 && val <= 6 ) || val == 8){
            return 3;
        }
        if(val == 7 ||val == 9 ){
            return 4;
        }

        return  -1;

    }
}
