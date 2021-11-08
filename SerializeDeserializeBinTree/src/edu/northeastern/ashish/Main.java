package edu.northeastern.ashish;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
public class Main {

    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<>();
        tree.root = createTree();

        String str = tree.serialize();

        Node<String> node = tree.deserialize(str);
        System.out.println(str);

    }

    private static Node<Integer> createTree(){
        Node<Integer> root = new Node(1);

        // Second level
        root.left = new Node<>(2);
        root.right = new Node<>(5);

        // Third Level
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(4);


        return root;
    }

}
