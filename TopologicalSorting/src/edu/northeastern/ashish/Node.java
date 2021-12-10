package edu.northeastern.ashish;

import java.util.LinkedList;

public class Node {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public LinkedList<Edge> getListEdges() {
        return listEdges;
    }

    public void setListEdges(LinkedList<Edge> listEdges) {
        this.listEdges = listEdges;
    }

    private String name;
    private boolean visited;
    private LinkedList<Edge> listEdges = null;

    public Node(String name) {
        this.name = name;
        this.visited = false;
        this.listEdges = new LinkedList<>();
    }

}
