package edu.northeastern.ashish;

public class Node {
    public String data;
    public Node parent;
    public int rank;

    public Node(String data){
        this.data = data;
        this.parent = this;
        this.rank = 1;
    }
}
