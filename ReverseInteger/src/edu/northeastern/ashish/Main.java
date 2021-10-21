package edu.northeastern.ashish;

//https://leetcode.com/problems/reverse-integer/

public class Main {

    public static void main(String[] args) {

        System.out.println(reverseInt(-123));
    }

    private static int reverseInt(int num){
        if(num == 0 ){
            return num;
        }
        boolean isnegative = num < 0;

        if(isnegative){
            num = num * -1;
        }

        int answer = 0;

        while(num != 0){
            answer = answer* 10 + num % 10;
            num = num / 10;
        }

        if(isnegative){
            answer = answer * -1;
        }

        return answer;
    }
}
