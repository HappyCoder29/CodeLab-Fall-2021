package edu.northeastern.ashish;

public class MaxMinStack  {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    private Stack<Integer> minStack;

    public MaxMinStack(){
        stack = new Stack<>();
        maxStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer data){
        if(stack.isEmpty()){
            stack.push(data);
            maxStack.push(data);
            minStack.push(data);
            return;
        }
        stack.push(data);

        if(data > maxStack.peek().data){
            maxStack.push(data);
        }else{
            maxStack.push(maxStack.peek().data);
        }

        if(data < minStack.peek().data){
            minStack.push(data);
        }else{
            minStack.push(minStack.peek().data);
        }
    }

    public Node<Integer> pop(){
        if(stack.isEmpty()){
            return null;
        }
        Node<Integer> node = stack.pop();
        maxStack.pop();
        minStack.pop();
        return node;
    }

    public Node<Integer> top(){
        if(stack.isEmpty()){
            return null;
        }

        return stack.peek();
    }

    public Integer getMin(){
        if(stack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return minStack.peek().data;
    }

    public Integer getMax(){
        if(stack.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return maxStack.peek().data;
    }

    public Node<Integer> popMax(){
        if(stack.isEmpty()){
            return null;
        }
        return popMaxMin(true);

    }


    public Node<Integer> popMin(){
        if(stack.isEmpty()){
            return null;
        }
        return popMaxMin(false);

    }

    private Node<Integer> popMaxMin(boolean removeMax){
        Stack<Integer> temp = new Stack<>();

        Stack<Integer> tempStack = removeMax == true ? maxStack : minStack;

        while(stack.peek().data != tempStack.peek().data){
            temp.push(stack.pop().data);
            maxStack.pop();
            minStack.pop();
        }
        Node<Integer> node = stack.pop();
        maxStack.pop();
        minStack.pop();

        while(!temp.isEmpty()){
            Integer data = temp.pop().data;
            stack.push(data);
            int max = maxStack.peek().data < data ? data : maxStack.peek().data;
            maxStack.push(max);
            int min = minStack.peek().data > data ? data : minStack.peek().data;
            minStack.push(min);
        }
        return node;
    }
}
