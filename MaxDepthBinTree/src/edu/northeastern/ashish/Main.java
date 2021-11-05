package edu.northeastern.ashish;
//https://leetcode.com/problems/maximum-depth-of-binary-tree/solution/
public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = createTree();

        System.out.println(tree.depth());
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
