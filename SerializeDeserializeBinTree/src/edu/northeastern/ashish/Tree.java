package edu.northeastern.ashish;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tree <T> {

    /// region Class 1

    public Node<T> root;

    public Tree() {
        this.root = null;
    }

    public String serialize(){
        String str = "";
        str =  serialize(root, str);
        int index =   str.lastIndexOf(", ");
        str = str.substring(0, index);
        return str;

    }
    public String serialize(Node<T> node, String str){
        if(node == null){
            str+= "Null, ";
        }else{
            str += node.data.toString() + ", ";
            str = serialize(node.left, str);
            str = serialize(node.right, str);

        }
        return str;
    }

    public Node<String> deserialize(String str){
        if(str == null || str.length() == 0 ){
            return null;
        }

        String[] arr = str.split(", ");
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, arr);
        return deserialize(list);

    }

    public Node<String> deserialize(ArrayList<String> list ){
        if( list.get(0).compareToIgnoreCase("Null") == 0){
            list.remove(0);
            return null;
        }
        Node<String> node = new Node(list.get(0));
        list.remove(0);
        node.left = deserialize(list);
        node.right = deserialize(list);

        return node;

    }



}
