package edu.northeastern.ashish;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Graph graph = initialize();
        LinkedList<LinkedList<Node>> minpaths =  graph.printAllPaths("0", "6");
        System.out.println();
    }

    private static Graph initialize(){
        Graph graph = new Graph();
        graph.addNode("0");
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");
        graph.addNode("6");


        // 0 edges
        graph.addEdge("0", "1",2);
        graph.addEdge("0", "6",7);
        graph.addEdge("0", "4",5);

        // 1 edges
        graph.addEdge("1", "0",2);
        graph.addEdge("1", "3",3);
        graph.addEdge("1", "2",3);

        // 2 edges
        graph.addEdge("2", "1",3);
        graph.addEdge("2", "5",1);

        // 3 edges
        graph.addEdge("3", "1",3);
        graph.addEdge("3", "6",3);
        graph.addEdge("3", "5",1);

        // 4 edges
        graph.addEdge("4", "0",5);
        graph.addEdge("4", "6",2);

        // 5 edges
        graph.addEdge("5", "2",1);
        graph.addEdge("5", "3",1);
        graph.addEdge("5", "6",1);

        // 6 edges
        graph.addEdge("6", "4",2);
        graph.addEdge("6", "0",7);
        graph.addEdge("6", "3",3);
        graph.addEdge("6", "5",1);

        return graph;
    }
}
