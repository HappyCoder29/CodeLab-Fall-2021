package edu.northeastern.ashish;
//https://leetcode.com/problems/check-if-n-and-its-double-exist/
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println(doubleExists(new int[]{10,2,5,3}));
    }
    private static boolean doubleExists(int[] arr){
        if(arr == null || arr.length <=1){
            return false;
        }
        HashSet<Float> set = new HashSet<>();

        for (int i : arr) {
            if( set.contains((float)i * 2) || set.contains((float)i / 2)){
                return true;
            }
            set.add((float) i);
        }

        return false;
    }
}
