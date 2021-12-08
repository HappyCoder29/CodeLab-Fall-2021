package edu.northeastern.ashish;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {
    }

    public String serialize(){
        if(root == null){
            return "null";
        }
        BoxValue<String> box = new BoxValue<>("");
        serialize(root, box);
        return box.value;
    }

    private void serialize(Node<T> node, BoxValue<String> box){
       if(node == null){
           box.value += ",null";
           return;
       }
       box.value += node.data + ", ";
       serialize(node.left, box);
       serialize(node.right, box);
    }
}
