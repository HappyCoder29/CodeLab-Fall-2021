package edu.northeastern.ashish;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache < S, T> {
    private HashMap<S, T> map;
    private LinkedList<S> list;
    private final Object obj;
    private int capacity;

    public LRUCache(int capacity){
        map = new HashMap<>();
        list = new LinkedList<>();
        obj = new Object();
        this.capacity = capacity;
    }

    public void addValue(S key , T data){

        synchronized (obj){
            if(map.containsKey(key)){
                // remove the data from the link list and add it to the start of the list
                list.remove(key);
                list.add(0, key);
            }else{
                // check if we are below capacity
                if (list.size() >= capacity) {
                    S remove = list.removeLast();
                    map.remove(remove);
                }
                list.add(0, key);
                map.put(key, data);
            }
        }

    }

    public T getValue(S key){
        synchronized (obj){
            return map.getOrDefault(key, null);
        }

    }




}
