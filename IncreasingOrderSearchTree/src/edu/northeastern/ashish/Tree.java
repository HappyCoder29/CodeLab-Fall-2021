package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tree <T> {

    public Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Node<T> convertToIncreasingOrderSearchTree() {
        if (root == null) {
            return null;
        }

        ArrayList<Node<T>> list = new ArrayList<>();

        convertToIncreasingOrderSearchTree(root, list);

        Node<T> newRoot = new Node<>(list.remove(0).data);
        Node<T> current = newRoot;

        for(int i = 0 ; i < list.size(); i ++){
            current.right = new Node<>(list.get(i).data);
            current= current.right;
        }

        return newRoot;

    }

    public void convertToIncreasingOrderSearchTree(Node<T> node, ArrayList<Node<T>> list) {
        if(node != null){
            convertToIncreasingOrderSearchTree(node.left, list);

            list.add(list.size(), node);

            convertToIncreasingOrderSearchTree(node.right, list );
        }

    }
}

