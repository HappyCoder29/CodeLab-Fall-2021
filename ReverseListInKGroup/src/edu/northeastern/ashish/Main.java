package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        SingleLinkList<Integer> list = new SingleLinkList<>();
        list.head = createList();
        list.reverseInGroupOfK(2);
    }

    public static Node<Integer> createList(){
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        head.next.next.next.next.next = new Node<>(6);
        return head;
    }
}
