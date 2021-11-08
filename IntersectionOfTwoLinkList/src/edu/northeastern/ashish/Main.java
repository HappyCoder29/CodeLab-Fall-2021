package edu.northeastern.ashish;
//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Main {

    public static void main(String[] args) {

        Node<Integer> list1 = getList1();
        Node<Integer> list2 = getList2();
        list2.next.next = list1.next;
        int count1 = getLength(list1);
        int count2 = getLength(list2);
        Node<Integer> temp1 = list1;
        Node<Integer> temp2 = list2;

        if(count1 > count2){
            for(int i = 0 ; i < count1-count2; i ++){
                temp1 = temp1.next;
            }
        }else{
            for(int i = 0 ; i < count2-count1; i ++){
                temp2 = temp2.next;
            }
        }

        while(temp1!= null){
            if(temp1 == temp2){
                System.out.println("Intersection point = " + temp1.data);
                return;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        System.out.println("Lists dont intersect");



    }

    public static Node<Integer> getList1(){
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);

        return head;

    }

    public static Node<Integer> getList2(){
        Node<Integer> head = new Node<>(6);
        head.next = new Node<>(7);


        return head;

    }

    private static int getLength(Node<Integer> node){
        if(node == null){
            return 0;
        }

        Node<Integer> temp = node;
        int count = 1;

        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;

    }
}
