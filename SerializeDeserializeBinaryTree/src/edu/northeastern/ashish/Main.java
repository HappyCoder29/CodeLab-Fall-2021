package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();
        String serialized = tree.serialize();
        System.out.println(serialized);

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
        root.left.left.right = new Node<>(9);
        root.left.right.left = new Node<>(10);
        root.left.right.right = new Node<>(11);
        root.right.left.left = new Node<>(12);

        root.right.right.left = new Node<>(13);



        //   root.right.right.left = new Node<>(13);



        return root;
    }
}
