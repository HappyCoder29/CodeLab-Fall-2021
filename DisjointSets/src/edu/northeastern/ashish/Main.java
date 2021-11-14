package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        DisjointSet set = new DisjointSet();
        set.addNode("A");
        set.addNode("B");
        set.addNode("C");
        set.addNode("D");

        set.union("A","C");
        set.union("A","B");

        System.out.println(set.findParent("B").data);


    }
}
