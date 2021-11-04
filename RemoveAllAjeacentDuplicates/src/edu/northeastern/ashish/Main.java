package edu.northeastern.ashish;

import java.util.Stack;
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class Main {

    public static void main(String[] args) {
        System.out.println(removeAdjacentDuplicates("abbaca"));
    }

    private static String removeAdjacentDuplicates(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if(!stack.isEmpty() && ch == stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
