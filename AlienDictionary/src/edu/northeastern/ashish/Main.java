package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        String[] words = {"z","x"};
        String sequence = graph.alienDictionary(words);
        System.out.println(sequence);

    }
}
