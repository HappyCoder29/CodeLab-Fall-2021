package edu.northeastern.ashish;

public class BST {
    public Node root;

    public BST() {

    }

    public Node inOrderSuccessor(int data){

        BoxValue box = new BoxValue();
        box.found = false;
        box.successor = null;
        inOrderSuccessor(root, data, box);
        return box.successor;
    }

    private void inOrderSuccessor(Node node, int data, BoxValue box){
        if(node != null){

            inOrderSuccessor(node.left, data, box);

            if(box.found == true && box.successor == null){
                box.successor = node;
                return;
            }

            if(node.data == data){
                // we have found the node
                box.found = true;
                // now we look for successor
                if(node.right != null){
                    Node successor = getMinNode(node.right);
                    box.successor = successor;
                    return;
                }
            }

            inOrderSuccessor(node.right, data, box);
        }
    }

    private Node getMinNode(Node node){
        if(node == null){
            return  null;
        }
        Node current = node;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }
}
