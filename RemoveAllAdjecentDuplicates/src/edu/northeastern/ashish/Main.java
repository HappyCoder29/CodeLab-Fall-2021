package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        System.out.println(removeAllAdjecentDuplicates("deeedbbcccbdaa", 3));
    }

    private static String removeAllAdjecentDuplicates(String str, int k){
        Stack<Character> stack = new Stack<>();
        for (Character ch : str.toCharArray()) {
            if(stack.size() < k) {
                stack.push(ch);
                continue;
            }
            if(stack.peek() == ch){
                ArrayList<Character> list = new ArrayList<>();
                for(int i = 0 ; i < k-1 ; i ++){
                    list.add(list.size(), stack.pop());
                    if(list.get(list.size()-1) != ch){
                        while(list.size()!= 0 ){
                            stack.push(list.remove(list.size()-1));
                        }
                    }
                }
            }else{
                stack.push(ch);
            }
        }

        ArrayList<Character> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(list.size() -1, stack.pop());
        }

        return list.toArray().toString();

    }
}
