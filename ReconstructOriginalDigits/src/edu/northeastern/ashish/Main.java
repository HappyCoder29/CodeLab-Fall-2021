package edu.northeastern.ashish;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.AbstractMap;
import java.util.Locale;

// 423. Reconstruct Original Digits from English

// Leet code https://leetcode.com/problems/reconstruct-original-digits-from-english/

public class Main {

    public static void main(String[] args) {

        String str = "zroefzevierofuro";

        System.out.println( reconstructOriginalDigits(str.toLowerCase()) );


    }

    private static String reconstructOriginalDigits(String str){
        StringBuilder sb = new StringBuilder();


        // replace zero
        String[] arr = removeCharsAndAddValues(str, 'z', "zero", 0);
        sb.append(arr[0]);
        str = arr[1];

        // replace two
        arr = removeCharsAndAddValues(str, 'w', "two", 2);
        sb.append(arr[0]);
        str = arr[1];
        // replace four
        arr = removeCharsAndAddValues(str, 'u', "four", 4);
        sb.append(arr[0]);
        str = arr[1];

        // replace six
        arr = removeCharsAndAddValues(str, 'x', "six", 6);
        sb.append(arr[0]);
        str = arr[1];

        // replace eight
        arr = removeCharsAndAddValues(str, 'g', "eight", 8);
        sb.append(arr[0]);
        str = arr[1];

        // replace three
        arr = removeCharsAndAddValues(str, 'h', "three", 3);
        sb.append(arr[0]);
        str = arr[1];

        // replace five
        arr = removeCharsAndAddValues(str, 'f', "five", 5);
        sb.append(arr[0]);
        str = arr[1];

        // replace seven
        arr = removeCharsAndAddValues(str, 's', "seven", 7);
        sb.append(arr[0]);
        str = arr[1];

        // replace nine
        arr = removeCharsAndAddValues(str, 'i', "nine", 9);
        sb.append(arr[0]);
        str = arr[1];

        // replace one
        arr = removeCharsAndAddValues(str, 'n', "one", 1);
        sb.append(arr[0]);
        //str = arr[1];

        return sb.toString();
    }

    private static String[] removeCharsAndAddValues(String str, char ch, String replace, int intVal){

        StringBuilder sb = new StringBuilder();
        while(str.indexOf(ch) != -1){
            sb.append(intVal);
            for (Character chars: replace.toCharArray()) {
                str = str.replaceFirst(Character.toString(chars), "");
            }
        }

        return new String[] {sb.toString(), str};
    }

}
