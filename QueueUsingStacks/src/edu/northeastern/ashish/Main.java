package edu.northeastern.ashish;
//https://leetcode.com/problems/implement-queue-using-stacks/solution/
public class Main {

    public static void main(String[] args) {
        QueueWithStacks<Integer> queue = new QueueWithStacks<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());



    }
}
