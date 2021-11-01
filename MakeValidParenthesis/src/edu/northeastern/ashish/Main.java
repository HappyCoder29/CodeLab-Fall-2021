package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class Main {

    public static void main(String[] args) {
        System.out.println(returnValidString("a)b(c)d"));
    }

    private static String returnValidString(String str){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();


        for(int i = 0 ; i < str.length(); i ++){
            char ch = str.charAt(i);

            if(ch == '('){
                stack.push(i);
            }
            if(ch == ')'){
                if(stack.isEmpty()){
                    // No matching string
                    list.add(i);
                }else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length(); i ++){
            if(!list.contains(i)){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
