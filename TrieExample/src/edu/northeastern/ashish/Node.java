package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public char ch;
    public List<Node> children;

    public Node(char ch){
        this.ch = ch;
        this.children = new LinkedList<>();
    }
}
