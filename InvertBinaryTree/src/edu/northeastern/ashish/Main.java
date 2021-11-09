package edu.northeastern.ashish;

import java.util.ArrayList;
//https://leetcode.com/problems/invert-binary-tree/
public class Main {

    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<>();
        tree.root = createTree();

        tree.levelOrder();
        tree.invertTree();
        tree.levelOrder();


        System.out.println();
    }


    private static Node<Integer> createTree(){
        Node<Integer> root = new Node(4);

        // Second level
        root.left = new Node<>(2);
        root.right = new Node<>(7);

        // Third Level
        root.left.left = new Node<>(1);
        root.left.right = new Node<>(3);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(9);
//
//        // Fourth Level
//        root.left.left.left = new Node<>(8);
//        root.left.right.left = new Node<>(9);
//        root.right.left.left = new Node<>(10);
//        root.right.right.right = new Node<>(11);

        return root;
    }
}
