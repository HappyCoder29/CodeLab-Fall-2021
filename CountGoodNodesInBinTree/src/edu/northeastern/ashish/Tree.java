package edu.northeastern.ashish;

import javax.swing.*;

public class Tree  {

    /// region Class 1

    public Node<Integer> root;

    public Tree() {
        this.root = null;
    }

    public int countNumberGoodNodes() {
        BoxValue box = new BoxValue();
        box.value = 0;
        countNumberGoodNodes(root, box, root.data);
        return box.value;
    }

    public void countNumberGoodNodes(Node node, BoxValue box, Integer maxValue) {
        if(node!= null){
            if((Integer)node.data >= maxValue){
                box.value ++;
            }
            countNumberGoodNodes(node.left, box, (Integer) node.data);
            countNumberGoodNodes(node.right , box, (Integer) node.data);

        }
    }
}
