package edu.northeastern.ashish;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class Main {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.root = createBST();
        tree.findKthSmallest(3);
    }

    private static  Node<Integer> createBST(){
        Node<Integer> root = new Node(8);

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


class Node <T>{
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BoxValue<T> {
    public T data;
    public BoxValue(T data){
        this.data = data;
    }
}

class Tree <T> {
    public Node<T> root;

    public Tree(){
        this.root = null;
    }

    public void inOrder(){
        System.out.print("[ ");
        inOrder(root);
        System.out.println(" ]");

    }
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + ",");
            inOrder(node.right);

        }
    }

    public void reverseInOrder(){
        System.out.print("[ ");
        reverseInOrder(root);
        System.out.println(" ]");

    }
    private void reverseInOrder(Node node){
        if(node != null){
            reverseInOrder(node.right);
            System.out.print(node.data + ",");
            reverseInOrder(node.left);

        }
    }

    public void findKthLargest(int k){
        BoxValue<Integer> box = new BoxValue<>(k);
        System.out.print("[ ");
        findKthLargest(root, box);
        System.out.println(" ]");

    }
    private void findKthLargest(Node node, BoxValue<Integer> box ){
        if(node != null){
            findKthLargest(node.right, box );
            box.data --;
            if(box.data == 0){
                System.out.print(node.data);
                return;
            }
            findKthLargest(node.left, box);
        }
    }

    public void findKthSmallest(int k){
        BoxValue<Integer> box = new BoxValue<>(k);
        System.out.print("[ ");
        findKthSmallest(root, box);
        System.out.println(" ]");

    }
    private void findKthSmallest(Node node, BoxValue<Integer> box ){
        if(node != null){
            findKthSmallest(node.left, box );
            box.data --;
            if(box.data == 0){
                System.out.print(node.data);
                return;
            }
            findKthSmallest(node.right, box);
        }
    }



}



