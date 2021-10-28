package edu.northeastern.ashish;

import java.util.Stack;
//https://leetcode.com/problems/valid-parentheses/
public class Main {

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }

    private static boolean isValid(String str){
        if(str.isEmpty()){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length(); i ++){
            if(     str.charAt(i) == '(' ||
                    str.charAt(i) == '{' ||
                    str.charAt(i) == '['){
                stack.push(str.charAt(i));
            }else{
                switch (str.charAt(i)){
                    case ')':
                        if(stack.pop() != '('){
                            return false;
                        }
                        break;
                    case '}':
                        if(stack.pop() != '{'){
                            return false;
                        }
                        break;
                    case ']':
                        if(stack.pop() != '['){
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;

    }
}
