package edu.northeastern.ashish;


public class Edge {
    public String startNode;
    public String endNode;
    public int weight;

    public Edge(String startNode, String endNode){
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = 1;

    }
    public Edge(String startNode, String endNode, int weight){
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;

    }

}