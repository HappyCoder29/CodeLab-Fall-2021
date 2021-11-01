package edu.northeastern.ashish;
//https://leetcode.com/problems/max-stack/
//https://leetcode.com/problems/min-stack/
public class Main {

    public static void main(String[] args) {

        MaxMinStack stack = new MaxMinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin()); // return -3
        System.out.println(stack.pop().data);
        System.out.println(stack.top().data);    // return 0
        System.out.println(stack.getMin()); // return -2


    }
}
