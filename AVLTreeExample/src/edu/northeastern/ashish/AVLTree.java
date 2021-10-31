package edu.northeastern.ashish;

public class AVLTree {

    public Node root;

    public  AVLTree(){

    }

    private int height(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node){
        if(node == null){
            return 0;
        }

        return  height(node.left) - height(node.right);
    }

    private Node rotateRight(Node A){
        Node temp = A.left;
        A.left = temp.right;
        temp.right = A;

        A.height = Math.max( height(A.left), height(A.right) ) + 1;
        temp.height = Math.max( height(temp.left), height(temp.right) ) + 1;
        return temp;

    }

    private Node rotateLeft(Node A){
        Node temp = A.right;
        A.right = temp.left;
        temp.left = A;

        A.height = Math.max( height(A.left), height(A.right) ) + 1;
        temp.height = Math.max( height(temp.left), height(temp.right) ) + 1;
        return temp;

    }
}
