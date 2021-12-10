package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        Graph graph = initialize();
//        Node node = graph.nodes.get("5");
//        graph.topologicalSorting(node);
      //  graph.topologicalSorting();
        graph.topologicalSortingAllNodes();
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


        graph.addEdge("2", "3");
        graph.addEdge("3", "1");
        graph.addEdge("4", "0");
        graph.addEdge("4", "1");
        graph.addEdge("5", "2");
        graph.addEdge("5", "0");
        graph.addEdge("0", "6");

        return graph;
    }
}
