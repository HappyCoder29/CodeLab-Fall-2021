package edu.northeastern.ashish;
//https://leetcode.com/problems/increasing-order-search-tree/
public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = createBST();
        Node<Integer> newRoot = tree.convertToIncreasingOrderSearchTree();
        System.out.println();
    }

    private static  Node<Integer> createBST(){
        Node root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right.left = new Node(13);

        return  root;
    }
}
