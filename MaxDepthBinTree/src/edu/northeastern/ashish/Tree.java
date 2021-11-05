package edu.northeastern.ashish;

public class Tree <T> {
    public Node<T> root;

    public Tree(){
        this.root = null;
    }

    public int depth(){
        return depth(root);
    }

    private int depth(Node node){
        if(node == null){
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;

    }
}