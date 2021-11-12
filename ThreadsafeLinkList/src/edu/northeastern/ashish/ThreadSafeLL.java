package edu.northeastern.ashish;

import java.util.LinkedList;

public class ThreadSafeLL <T> {
    private LinkedList<T> list;
    private static Object obj;

    public ThreadSafeLL(){
        list = new LinkedList<>();
        obj = new Object();
    }


    public void addAtPosition(int index, T element){
        synchronized (obj){
            System.out.println(" Index = " + index + " list.size = " + list.size());
            list.add(index, element);
        }

    }

    public void removeAtPosition(int index){

        synchronized (obj){
            if(list.size() <= index || index <0){
                return;
            }
            System.out.println("Thread name = " + Thread.currentThread().getName() +  " List Size = " + list.size() + " Index = " + index);
            list.remove(index);
        }
    }
    public T getFirst() {
        synchronized (obj){
            return list.getFirst();
        }
    }

    public T getLast() {
        synchronized (obj){
            return list.getLast();
        }
    }

    public int size(){
        synchronized (obj){
            return list.size();
        }
    }

}
