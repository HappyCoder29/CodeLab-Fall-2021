package edu.northeastern.ashish;

public class BST {
    public Node root;

    public BST() {

    }

    public boolean isValidBST(){
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBST(Node node, int low, int high){
        if(node == null){
            return true;
        }

        // Check if the value is valid
        if(node.data < low || node.data > high){
            return false;
        }

        return  isValidBST(node.left, low, node.data) &&
                isValidBST(node.right, node.data, high);
    }
}
