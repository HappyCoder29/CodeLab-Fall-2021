package edu.northeastern.ashish;

public class Stack <T>{
    public Node<T> head;

    public Stack(){
        head = null;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    public T pop(){
        if(head == null){
            return null;
        }
        Node<T> node = head;
        head = head.next;
        node.next = null;
        return node.data;
    }

    public T peek(){
        return head.data;
    }
    public int size(){
        int count = 0;
        Node<T> temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public boolean isEmpty(){
        return head == null;
    }


}
