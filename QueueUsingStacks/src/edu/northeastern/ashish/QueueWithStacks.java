package edu.northeastern.ashish;

import java.util.Stack;

public class QueueWithStacks <T> {
    private Stack<T> stackMain;
    private Stack<T> stackCopy;

    public QueueWithStacks(){
        stackMain = new Stack<>();
        stackCopy = new Stack<>();
    }

    public boolean isEmpty(){
        return stackMain.isEmpty();
    }

    public T dequeue(){
        if(stackMain.isEmpty()){
            return null;
        }

        while(!stackMain.isEmpty()){
            stackCopy.push(stackMain.pop());
        }
        T data = stackCopy.pop();
        while(!stackCopy.isEmpty()){
            stackMain.push(stackCopy.pop());
        }
        return data;
    }

    public void enqueue(T data){
        stackMain.push(data);
    }

    public T peek(){
        if(stackMain.isEmpty()){
            return null;
        }

        while(!stackMain.isEmpty()){
            stackCopy.push(stackMain.pop());
        }
        T data = stackCopy.peek();
        while(!stackCopy.isEmpty()){
            stackMain.push(stackCopy.pop());
        }
        return data;
    }

}
