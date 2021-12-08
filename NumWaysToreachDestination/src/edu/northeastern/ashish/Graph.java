package edu.northeastern.ashish;

import java.util.*;

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
        Node node1 = nodes.get(node1Name);
        Node node2 = nodes.get(node2Name);
        if( !nodes.containsKey(node1.getName()) || !nodes.containsKey(node2.getName())){
            return;
        }

        Edge edge = getEdge(node1, node2);
        if(edge == null){
            edge = new Edge(node1.getName(), node2.getName());
            node1.getListEdges().add(edge);
        }

    }
    public void addEdge(String node1Name, String node2Name, int weight){
        Node node1 = nodes.get(node1Name);
        Node node2 = nodes.get(node2Name);
        if( !nodes.containsKey(node1.getName()) || !nodes.containsKey(node2.getName())){
            return;
        }

        Edge edge = getEdge(node1, node2);
        if(edge == null){
            edge = new Edge(node1.getName(), node2.getName(), weight);
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


    public void breadthFirstSearch(String startNode){
        startNode = startNode.toUpperCase();
        if(!nodes.containsKey(startNode)){
            return;
        }
        resetVisited();
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes.get(startNode));
        queue.add(null);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node != null){
                if(node.isVisited() == false){
                    System.out.print(node.getName() + " ");
                }
                node.setVisited(true);
                for (Edge edge : node.getListEdges()) {
                    Node neighbour = nodes.get(edge.endNode);
                    if(neighbour.isVisited() == false){
                        queue.add(neighbour);
                    }
                }
                // end of if node != null
            }else{
                // Node is null
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }// end of else node == null
        }// end of queue is empty

    }// end of function


    public void depthFirstSearch(String startNode, String endNode){
        startNode = startNode.toUpperCase();
        if(!nodes.containsKey(startNode)){
            return;
        }
        resetVisited();
        Stack<Node> stack = new Stack<>();
        stack.add(nodes.get(startNode));
        String str = "";
        while(!stack.isEmpty()){
            Node node = stack.pop();

            if(node.isVisited() == false){
                System.out.print(node.getName() + " ");
                str += node.getName() + ", ";
            }
            node.setVisited(true);
            if(node == nodes.get(startNode) ){
                System.out.println(str);
            }
            for (Edge edge : node.getListEdges()) {
                Node neighbour = nodes.get(edge.endNode);
                if(neighbour.isVisited() == false){
                    stack.push(neighbour);
                }
            }
        }// end of queue is empty

    }// end of function


    private Edge findEdge(String source, String dest){
        Node node= nodes.get(source);
        if(node == null){
            return null;
        }
        for (Edge edge: node.getListEdges()) {
            if(edge.endNode == dest){
                return edge;
            }
        }
        return null;
    }


    public LinkedList<LinkedList<Node>> printAllPaths(String source, String dest){
        source = source.toUpperCase();
        dest = dest.toUpperCase();

        if( !nodes.containsKey(source) || !nodes.containsKey(dest) ){
            return null;
        }

        LinkedList<LinkedList<Node>> paths = new LinkedList<>();
        LinkedList<LinkedList<Node>> minPaths = new LinkedList<>();
        BoxValue<Integer> box = new BoxValue<>();
        box.value = Integer.MAX_VALUE;
        LinkedList<String> visited = new LinkedList<>();
        printAllPaths(visited, source, dest, 0, box, paths);


        for (LinkedList<Node> path : paths) {
            int dist = 0;
            for(int i = 0 ; i < path.size()-1; i ++){
                Edge edge = findEdge(path.get(i).getName(), path.get(i+1).getName());
                dist += edge.weight;
            }
            if(dist == box.value){
                minPaths.add(path);
            }
        }

        return minPaths;

    }


    private void printAllPaths(LinkedList<String> visited, String current, String dest, int distance, BoxValue<Integer> box,
                               LinkedList<LinkedList<Node>> paths){
        if( visited.contains(current) ){
            return;
        }
        if(dest == current){
            LinkedList<Node> list = new LinkedList<>();
            for (String str : visited) {
                System.out.print(str + " -> ");
                list.add(nodes.get(str));
            }
            list.add(nodes.get(dest));
            paths.add(list);
            System.out.println(dest + " Distance = " + distance);
            if(box.value > distance){
                box.value = distance;
            }
        }

        visited.add(current);

        Node node = nodes.get(current);
        for (Edge edge : node.getListEdges()) {
            if( ! visited.contains(edge.endNode) ){
                printAllPaths(visited, edge.endNode, dest, distance + edge.weight, box, paths);
            }
        }

        visited.remove(current);
    }




}

