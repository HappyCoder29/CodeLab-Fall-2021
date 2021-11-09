package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class Tree <T> {

    public Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void invertTree(){
        invertTree(root);
    }
    private void invertTree(Node<T> node){
        if(node == null){
            return;
        }

        invertTree(node.left);
        invertTree(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    /// Level Order
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue< Node<T> > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while( queue.isEmpty() == false ){
            Node<T> node = queue.remove();
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

