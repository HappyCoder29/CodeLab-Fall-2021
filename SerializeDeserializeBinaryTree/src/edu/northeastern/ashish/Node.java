package edu.northeastern.ashish;

public class Node <T>{
    public Node<T> left;
    public Node<T> right;
    public T data;

    public Node(T data){
        this.data = data;
    }
}
