package edu.northeastern.ashish;
//https://leetcode.com/problems/inorder-successor-in-bst/solution/
public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = createBST();

        Node successor =  bst.inOrderSuccessor(14);
        if(successor != null) {
            System.out.println(successor.data);
        }else{
            System.out.println("No Successor");

        }
    }

    private static  Node createBST(){
        Node root = new Node(8);

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
