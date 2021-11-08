package edu.northeastern.ashish;

import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public Node root;

    public BST() {

    }

    public void deleteNode(int data){
        deleteNode(root, data);
    }

    private Node deleteNode(Node node, int data){
        if(node == null){
            return null;
        }
        if(node.data > data){
            node.left = deleteNode(node.left, data);
        }else if (node.data < data){
            node.right = deleteNode(node.right, data);
        }else{
            // The node value is the one we want to delete
            if(node.left == null && node.right == null){
                node = null;
            }
            else if (node.right != null) {
                node.data = getMinimum(node.right).data;
                node.right = deleteNode(node.right, node.data);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                node.data = getMaximum(node.left).data;
                node.left = deleteNode(node.left, node.data);
            }

        }

        return node;
    }

    private Node getMinimum(Node node){
        Node temp = node;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    private Node getMaximum(Node node){
        Node temp = node;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    /// Level Order
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue< Node > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while( queue.isEmpty() == false ){
            Node node = queue.remove();
            if(node != null){
                System.out.print(node.data + ", ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println();

                // Node was null
                // Check if the queue is empty if it is then break out of the loop
                // otherwise we will go in infinite loop
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }
        }
        System.out.println();
    }


}
