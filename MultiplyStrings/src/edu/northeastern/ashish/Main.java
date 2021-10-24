package edu.northeastern.ashish;
// https://leetcode.com/problems/multiply-strings/
public class Main {

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        System.out.println(multiply(num1, num2));

    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int[] ans = new int[num1.length() + num2.length() - 1];

        //First we multiply each number in num1 and num2:
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        //Then we add the carry of ans[i] to ans[i-1]
        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }

        return sb.toString();
    }
}
