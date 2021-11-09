package edu.northeastern.ashish;

import java.util.ArrayList;
//https://leetcode.com/problems/binary-tree-vertical-order-traversal/
public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = createTree();
        ArrayList<ArrayList<Node<Integer>>>  list =  tree.getListVerticalOrder();

        for (ArrayList<Node<Integer>> listNodes: list) {
            for (Node<Integer> node: listNodes) {
                System.out.print(node.data + ", ");
            }
            System.out.println();
        }


        System.out.println();
    }



    private static Node<Integer> createTree(){
        Node<Integer> root = new Node(3);

        // Second level
        root.left = new Node<>(9);
        root.right = new Node<>(20);

        // Third Level
        root.right.left = new Node<>(15);
        root.right.right = new Node<>(7);
//
//        // Fourth Level
//        root.left.left.left = new Node<>(8);
//        root.left.right.left = new Node<>(9);
//        root.right.left.left = new Node<>(10);
//        root.right.right.right = new Node<>(11);

        return root;
    }
}
