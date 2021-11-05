package edu.northeastern.ashish;
//https://leetcode.com/problems/balanced-binary-tree/
public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = createTree();

        System.out.println(tree.isBalanced());
    }

    private static Node<Integer> createTree(){
        Node<Integer> root = new Node(1);

        // Second level
        root.left = new Node<>(2);
        root.right = new Node<>(3);

        // Third Level
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        // Fourth Level
        root.left.left.left = new Node<>(8);
        root.left.right.left = new Node<>(9);
        root.right.left.left = new Node<>(10);
        root.right.right.right = new Node<>(11);

        return root;
    }
}


class Node <T>{
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree <T> {
    public Node<T> root;

    public Tree(){
        this.root = null;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int leftHeight = depth(node.left);
        int rightHeight = depth(node.right);

        if(Math.abs(leftHeight-rightHeight) > 1){
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);


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
