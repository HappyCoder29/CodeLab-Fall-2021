package edu.northeastern.ashish;

import java.util.Locale;

public class Trie {
    Node root;

    public Trie(){
        root = new Node('\0');
    }

    public void addString(String str){
        Node current = root;
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            Node child = findChildren(current, ch);
            if(child == null){
                child = new Node(ch);
                current.children.add(child);
            }
            current = child;
        }
    }

    public Node findChildren( Node node, char ch){
        for (Node child : node.children) {
            if(ch == child.ch){
                return child;
            }
        }
        return null;
    }

    public boolean doesExist(String str){
        Node current = root;
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            Node child = findChildren(current, ch);
            if(child == null){
                return  false;
            }
            current = child;
        }
        return true;
    }


}
