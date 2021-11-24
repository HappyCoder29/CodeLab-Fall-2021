package edu.northeastern.ashish;
public class Node <T>{
    public T data;
    public Node<T> left;
    public Node<T> right;
    public int height;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
