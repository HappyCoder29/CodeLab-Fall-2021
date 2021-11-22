package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//https://leetcode.com/problems/find-median-from-data-stream/solution/
public class Median {
    ArrayList<Integer> list;

    public Median() {
       list = new ArrayList<>();
    }

    public void addNum(int num) {
       list.add(num);
       list.sort(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o1.compareTo(o2);
           }
       });
    }

    public double findMedian() {
        if(list.size()%2 != 0){
           return list.get(list.size()/2);
        }
        double num1 = list.get(list.size()/2 -1);
        double num2 = list.get(list.size()/2);
        return (num1 + num2 )/2;
    }
}
