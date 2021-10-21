package edu.northeastern.ashish;

//https://leetcode.com/problems/reverse-integer/

public class Main {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(reverseInt(-123));
    }

    private static int reverseInt(int num){
        if(num == 0 ){
            return num;
        }


        int answer = 0;

        while(num != 0){

            int pop = num % 10;

            if (answer > Integer.MAX_VALUE/10 || (answer == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if (answer < Integer.MIN_VALUE/10 || (answer == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }

            answer = answer* 10 + num % 10;
            num = num / 10;
        }



        return answer;
    }
}
