package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Graph {

    public HashMap<String, Node> nodes;
    public Graph() {
        nodes = new HashMap<>();
    }

    public void addNode(String name){
        name = name.toUpperCase();
        if(nodes.containsKey(name)){
            return;
        }
        Node node = new Node(name);
        nodes.put(name, node);
    }

    public void addEdge(String node1Name, String node2Name){
        Node node1 = nodes.get(node1Name.toUpperCase());
        Node node2 = nodes.get(node2Name.toUpperCase());
        if( !nodes.containsKey(node1.getName()) || !nodes.containsKey(node2.getName())){
            return;
        }

        Edge edge = getEdge(node1, node2);
        if(edge == null){
            edge = new Edge(node1.getName(), node2.getName());
            node1.getListEdges().add(edge);
        }

    }

    private Edge getEdge(Node node1, Node node2){

        for (Edge  edge: node1.getListEdges()) {
            if(edge.endNode.equals(node2.getName())){
                return edge;
            }
        }
        return null;
    }

    private void resetVisited(){
        nodes.forEach( (k,v) ->{
            v.setVisited(false);
        });
    }

    private ArrayList<Node> getChildren(Node node){
        ArrayList<Node> listNeighbours = new ArrayList<>();
        for (Edge edge : node.getListEdges()) {
            listNeighbours.add(nodes.get(edge.endNode));
        }
        return listNeighbours;
    }



    public void topologicalSorting() {

        ArrayList<String> list = new ArrayList<>();
        for (Node node : nodes.values()) {
            Stack<Node> stack = new Stack<>();
            topologicalSorting(node, stack);
            String str = "";
            while(!stack.isEmpty()){
                str += stack.pop().getName() + ", ";
            }
            list.add(str);
        }
        for (String str : list) {
            System.out.println(str);
        }

    }




    public void topologicalSorting(Node node) {
        if(!nodes.containsKey( node.getName().toUpperCase())){
            return;
        }

        Stack<Node> stack = new Stack<>();
        topologicalSorting(node, stack);

        while(!stack.isEmpty()){
            System.out.print(stack.pop().getName() + ", ");
        }
        System.out.println();
    }
    public void topologicalSorting(Node node, Stack<Node> stack){

        for (Node n: getChildren(node)) {
            if(!stack.contains(n)){
                topologicalSorting(n, stack);
            }
        }
        stack.push(node);
    }


    public String topologicalSortingAllNodes(){
        Stack<Node> stack = new Stack<>();
        for (Node node : nodes.values()){
            if(!stack.contains(node)){
                topologicalSorting(node, stack);
            }
        }
        String str = "";
        while(!stack.isEmpty()){
            str += stack.pop().getName() + ", ";
            //System.out.print(stack.pop().getName() + ", ");
        }
       // System.out.println();
        return str;
    }


    public String alienDictionary(String[] words){

        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                this.addNode(ch.toString());
            }
        }

        // Add edges
        for(int i = 0 ; i < words.length - 1 ; i ++){
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());

            for(int j = 0 ; j < len; j ++){
                // If chars match just continue
                if(word1.charAt(j) == word2.charAt(j)){
                    continue;
                }
                // if they don't match make an edge from first word char to second word char and break;
                String start = Character.toString(word1.charAt(j));
                String end = Character.toString(word2.charAt(j));

                this.addEdge(start, end);
                break;

            }
        }

        // At the end of this all the edges are made
        // All we have to do it topological sort for all nodes
        return  this.topologicalSortingAllNodes();

    }



}

