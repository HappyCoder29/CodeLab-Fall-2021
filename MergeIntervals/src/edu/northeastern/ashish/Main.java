package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
//https://leetcode.com/problems/merge-intervals/
public class Main {

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(-5,0));
        intervals.add(new Interval(-2,1));
        intervals.add(new Interval(10,11));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(9,13));
        intervals.add(new Interval(3,6));

        ArrayList<Interval> merged = mergeIntervals(intervals);
    }

    // Sorting of intervals would be O(nLogn) and then finding intervals would be O(n)
    // Total complexity would be O(nLogn)
    private static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals){
        if(intervals == null || intervals.size() <= 1  )
            return  intervals;

        intervals.sort(new Comparator<>() {
            @Override
            public int compare(Interval x, Interval y) {
                return Integer.compare(x.start, y.start);
            }
        });
        Stack<Interval> stack =   new Stack<>();
        stack.push(intervals.get(0));
        for(int i = 1; i < intervals.size(); i ++){
            Interval top = stack.peek();
            Interval current = intervals.get(i);
            if(top.end < current.start){
                stack.push(intervals.get(i)); // Intervals dont intersect
            }
            else if(top.end < current.end) {
                top.end = current.end;
                stack.pop();
                stack.push(top);
            }
        }
        ArrayList<Interval> merged = new ArrayList<>();

        while(stack.size() != 0) {
            merged.add(stack.pop());
        }

        return  merged;
    }
}
