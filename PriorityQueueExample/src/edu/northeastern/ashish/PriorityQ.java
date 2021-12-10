package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQ<T extends Comparable> {
    ArrayList<T> list;
    int size;
    int current;

    public PriorityQ(int size){
        this.list = new ArrayList<>();
        this.current = 0;
    }

    public boolean isEmpty(){
        return  current == 0;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return list.get(0);
    }

    private int getParentIndex(int index){
        return  (index -1)/2;
    }

    private int getLeftChildIndex(int index){
        return  2*index + 1;
    }
    private int getRightChildIndex(int index){
        return  2*index + 2;
    }

    public void add(T data){
        list.add(current, data);
        current ++;
        siftUp(current);
    }

    private void siftUp(int current){
        if(current == 0){
            return;
        }
        int parentIndex = getParentIndex(current);
        if(list.get(parentIndex).compareTo(list.get(current))  < 0 ){
            return;
        }
        T temp = list.get(parentIndex);
        list.add(parentIndex, list.get(current));
        list.add(current, temp);

        siftUp(parentIndex);

    }



}
