package edu.northeastern.ashish;

public class Stack  <T>{
    public Node<T> head;

    public Stack(){

    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(T data){
        Node<T> node = new Node<>(data);
        if(head == null){
            head = node;
            head.next = null;
            head.previous = null;
            return;
        }

        node.previous = head;
        head.next = node;
        head = node;

    }

    public Node<T> peek(){
        return head;
    }

    public Node<T> pop(){
        Node node = head;
        if(head == null){
            return null;
        }

        head = head.previous;
        if(head != null){
            head.next = null;
        }

        return node;
    }

}
