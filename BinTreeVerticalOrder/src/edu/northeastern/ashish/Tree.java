package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tree <T> {

    public Node<T> root;

    public Tree() {
        this.root = null;
    }

    public ArrayList< ArrayList<Node<T>> > getListVerticalOrder(){
        ArrayList< ArrayList<Node<T>> > list = new ArrayList<>();
        HashMap<Integer, ArrayList<Node<T>>> map = new HashMap<>();
        if(root == null){
            return list;
        }

        getListVerticalOrder(root, map, 0);

        for (Map.Entry<Integer, ArrayList<Node<T>>> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    private void getListVerticalOrder(Node<T> node, HashMap<Integer, ArrayList<Node<T>>> map, int index){
        if(node != null ){
            ArrayList<Node<T>> al;
            if(!map.containsKey(index)){
                al = new ArrayList<>();
            }else{
                al = map.get(index);
            }
            al.add(node);
            map.put(index, al);


            getListVerticalOrder(node.left, map, index -1);
            getListVerticalOrder(node.right , map, index + 1);
        }
    }


}
