package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        SuffixTrie trie = new SuffixTrie();
        trie.addString("abaabab");
        System.out.println(trie.isSubstring("aaaba") );
        System.out.println(trie.findNumOfTimesRepeated("ab"));
        ArrayList<String> list =trie.numberOfDistinctSubstringsInAString("aabbaba");
        System.out.println(Arrays.asList(list).toString());

    }
}
