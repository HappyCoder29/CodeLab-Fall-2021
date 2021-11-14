package edu.northeastern.ashish;

import java.util.HashMap;
import java.util.LinkedList;

public class DisjointSet {
    private HashMap<String, Node> map;
    public DisjointSet(){
        map = new HashMap<>();
    }

    public void addNode(String data){
        if(map.containsKey(data)){
            return;
        }
        map.put(data, new Node(data));
    }

    public Node findParent(String data){
        if(!map.containsKey(data)){
            return null;
        }
        Node node = map.get(data);

        while(node.parent != node){
            node = node.parent;
        }
        return node;
    }

    public void union(String data1, String data2){
        if(!map.containsKey(data1) || !map.containsKey(data2)){
            return;
        }

        Node parent1 = findParent(data1);
        Node parent2 = findParent(data2);

        if(parent1 == parent2){
            return;
        }
        if(parent1.rank ==  parent2.rank){
            parent2.parent = parent1;
            parent1.rank ++;
        }else if(parent1.rank > parent2.rank){
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }

    }
}
