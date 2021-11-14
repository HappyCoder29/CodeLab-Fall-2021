package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class SuffixTrie {
    Node root;

    public SuffixTrie(){
        root = new Node('\0');

    }

    public void addString(String str){
        str = str.toLowerCase();
        str += "$";

        for(int i = str.length() -1 ; i >= 0; i --){
            insert(str.substring(i));
        }
    }

    private void insert(String str){
        Node current = root;

        for (char ch : str.toCharArray()) {
            Node child = findChild(current, ch);
            if(child == null){
                child = new Node(ch);
                current.children.add(child);
            }
            current = child;

        }
    }

    private Node findChild(Node node, char ch){

        for (Node child : node.children) {
            if(child.ch == ch){
                return child;
            }
        }
        return null;
    }

    public boolean isSubstring(String str){
        Node current = root;

        for (char ch : str.toCharArray()) {
            Node child = findChild(current, ch);
            if(child == null){
               return false;
            }
            current = child;
        }
        return true;
    }


    public int findNumOfTimesRepeated(String str){
        Node current = root;

        for (char ch : str.toCharArray()) {
            Node child = findChild(current, ch);
            if(child == null){
                return 0;
            }
            current = child;
        }

        // return all the $ signs from this point on
        return findAllTerminalChars(current);

    }

    private int findAllTerminalChars(Node node){

        int result = node.ch == '$' ? 1 : 0;

        for(Node child : node.children){
            result +=  findAllTerminalChars(child);
        }

        return result;
    }

    public ArrayList<String> numberOfDistinctSubstringsInAString(String str){
        str = str + "$";
        ArrayList<String> list = new ArrayList<>();
        for(int i = str.length() -1 ; i >= 0; i --){
            System.out.println(str.substring(i));
        }
        return list;
    }




}
