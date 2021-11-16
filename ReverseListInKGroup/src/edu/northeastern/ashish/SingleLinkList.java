package edu.northeastern.ashish;

public class SingleLinkList <T> {

    public Node<T> head;
    public int count = 0;
    public Node<T> tail;

    public SingleLinkList() {
        head = null;
        count = 0;
    }

    private Node<T> getLastNode(Node<T> node){
        if(node == null){
            return node;
        }
        Node<T> current = node;
        while(current.next != null){
            current = current.next;
        }
        return current;
    }

    public void reverseInGroupOfK(int k) {
        if(k <= 1){
            return;
        }
        reverseList(head, k);

        System.out.println();


    }

    public Node<T> reverseList(Node<T> node, int k){
        if(node == null || node.next == null){
            return node;
        }

        Node<T> back = null;
        Node<T> mid = node;
        Node<T> front = node.next;
        while(front != null){
            for(int i = 0 ; i < k ; i ++){
                mid.next = back;
                back = mid;
                mid = front;
                front = front.next;
            }
        }


        return  back;
    }
}
