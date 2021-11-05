package edu.northeastern.ashish;

import java.util.HashSet;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = createTree();
        Node<Integer> node1 = tree.root.left.left; //(4)
        Node<Integer> node2 = tree.root.left.right.left; //(9)

        System.out.println(tree.findCommonAncestor(node1, node2).data);

    }


    private static Node<Integer> createTree(){
        Node<Integer> root = new Node(1);
        root.parent = root;

        // Second level
        root.left = new Node<>(2);
        root.left.parent = root;
        root.right = new Node<>(3);
        root.right.parent = root;

        // Third Level
        root.left.left = new Node<>(4);
        root.left.left.parent = root.left;
        root.left.right = new Node<>(5);
        root.left.right.parent = root.left;
        root.right.left = new Node<>(6);
        root.right.left.parent = root.right;
        root.right.right = new Node<>(7);
        root.right.right.parent = root.right;
        // Fourth Level
        root.left.left.left = new Node<>(8);
        root.left.left.left.parent = root.left.left;
        root.left.right.left = new Node<>(9);
        root.left.right.left.parent = root.left.right;
        root.right.left.left = new Node<>(10);
        root.right.left.left.parent = root.right.left;
        root.right.right.right = new Node<>(11);
        root.right.right.right.parent = root.right.right;
        return root;
    }
}



class Node <T>{
    public T data;
    public Node<T> left;
    public Node<T> right;
    public Node<T> parent;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class Tree <T> {
    public Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Node<T> findLowestCommonAncestorWithParent(Node node1, Node node2){
        HashSet<Node<T>> set = new HashSet<>();

        while(true ){

            if(!set.contains(node1)){
                set.add(node1);
            }
            else{
                if(node1.parent != node1){
                    return node1;
                }
            }

            if(!set.contains(node2)){
                set.add(node2);
            }else{
                if(node2.parent != node2){
                    return node2;
                }
            }
            if(node1.parent != node1){
                node1 = node1.parent;
            }
            if(node2.parent != node2){
                node2 = node2.parent;
            }

            if(node1.parent == node1 && node2.parent== node2){
                return node1;
            }
        }
    }

    public Node<T> findCommonAncestor(Node node1, Node node2){

        return  findCommonAncestor(root, node1, node2);
    }

    private Node<T> findCommonAncestor(Node<T> node, Node<T> node1, Node<T> node2){
        if(node == null){
            return null;
        }
        if(node == node1 || node == node2){
            return node;
        }
        Node<T> leftSide = findCommonAncestor(node.left, node1, node2);
        Node<T> rightSide = findCommonAncestor(node.right, node1, node2);

        if(leftSide != null && rightSide != null){
            return node;
        }
        if(leftSide != null){
            return findCommonAncestor(node.left, node1, node2);
        }else{
            return findCommonAncestor(node.right, node1, node2);
        }
    }
}
