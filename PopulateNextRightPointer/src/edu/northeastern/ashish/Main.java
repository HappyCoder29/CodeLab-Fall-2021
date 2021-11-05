package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = createTree();
        tree.populateNextRight();
        tree.printNextRight();
        System.out.println();

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
    public Node<T> nextRight;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }
}

class Tree <T> {

    /// region Class 1

    public Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void printNextRight(){
        if(root == null || (root.left== null && root.right == null) ){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size() != 0){

            Node<T> node = queue.remove();
            if(node != null){
                if(node.nextRight == null){
                    System.out.print(node.data + "-> Null");
                }else{
                    System.out.print(node.data + "->");
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println();
                // this is a new level
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
            }
        }
    }



    public void populateNextRight(){
        if(root == null || (root.left== null && root.right == null) ){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<T> prevNode = null;
        while(queue.size() != 0){

            Node<T> node = queue.remove();
            if(node != null){
                if(prevNode != null){
                    prevNode.nextRight = node;
                }
                prevNode = node;
                System.out.print(node.data + ", ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println();
                // this is a new level
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
                prevNode = null;
            }
        }
    }
}
