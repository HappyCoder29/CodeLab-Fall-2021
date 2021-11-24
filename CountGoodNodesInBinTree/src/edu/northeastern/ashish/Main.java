package edu.northeastern.ashish;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = createTree();
        System.out.println(tree.countNumberGoodNodes());

    }

    private static Node<Integer> createTree(){
        Node<Integer> root = new Node(3);

        // Second level
        root.left = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(2);

//
//        // Third Level
//        root.left.left = new Node<>(3);
//        root.right.left = new Node<>(1);
//        root.right.right = new Node<>(5);

        return root;
    }
}
