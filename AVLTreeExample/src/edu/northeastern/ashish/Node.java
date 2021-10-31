package edu.northeastern.ashish;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public int height ;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

