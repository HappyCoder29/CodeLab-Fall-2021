package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        Median median = new Median();
        median.addNum(1);
        median.addNum(2);
        System.out.println(median.findMedian());
        median.addNum(3);
        System.out.println(median.findMedian());


    }
}
