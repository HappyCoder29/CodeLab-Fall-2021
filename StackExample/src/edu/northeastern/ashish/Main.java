package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(-4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());




    }
}
