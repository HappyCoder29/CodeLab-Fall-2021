package edu.northeastern.ashish;

//https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
public class Main {

    public static void main(String[] args) {
        String[] arr = {"i","love","grapes","apples"};
        String str = "ilovegrapes";
        System.out.println(checkIfStringIsPrefix(arr, str));
    }

    private static boolean checkIfStringIsPrefix(String[] arr, String str){
        String temp = "";
        for(int i = 0; i < arr.length; i ++){
            temp += arr[i];
            if( temp.equals(str) ){
                return true;
            }
        }
        return false;
    }
}
