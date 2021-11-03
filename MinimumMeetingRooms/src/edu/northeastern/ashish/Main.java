package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Comparator;
//https://leetcode.com/problems/meeting-rooms-ii/
public class Main {

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(0,30));
        list.add(new Interval(5,10));
        list.add(new Interval(15,20));
        list.add(new Interval(17,24));
        list.add(new Interval(25,35));
        list.add(new Interval(45,60));

//        //[7,10],[2,4]

        System.out.println(minimumMeetingRooms(list));
    }


    private static int minimumMeetingRooms(ArrayList<Interval> intervals){
        // If there are only 0 intervals return 0
        if(intervals == null || intervals.size() <= 1  )
            return  0;

        // Sort intervals based on start time
        intervals.sort(new Comparator<>() {
            @Override
            public int compare(Interval x, Interval y) {
                return Integer.compare(x.start, y.start);
            }
        });


        // Initialize current interval as the first interval and make count = 1 and maxCouint = 1
        Interval current = intervals.get(0);
        int count = 1;
        int maxCount = 1;

        // Compare all the intervals
        for(int i = 1 ; i < intervals.size(); i ++){

            // If the ith interval is totally inside the current interval
            if(intervals.get(i).end < current.end){

                // Compare ith Interval with previous interval and check if they overlap too
                // if they overlap then inmcrement the count else no need to increment
                if (intervals.get(i).start < intervals.get(i-1).end){
                    count++;
                }

                // Update max count if needed
                if(maxCount < count ){
                    maxCount++;
                }
                continue;
            }

            //If the ith interval is not totally inside current interval but they are still overlapping
            // example Current = [5,10] ith = [7,15]
            if(intervals.get(i).start < current.end){
                // Compare ith Interval with previous interval and check if they overlap too
                // if they overlap then inmcrement the count else no need to increment
                if (intervals.get(i).start < intervals.get(i-1).end){
                    count++;
                }
                // Update max count if needed
                if(maxCount < count){
                    maxCount++;
                }
                continue;
            }

            //Ifg we reach here that means that the current and ith intyerval dont match at all
            // in this case we will make the ith interval as current interval and make count = 1
            current = intervals.get(i);
            count = 1;
        }

        return  maxCount;






    }
}
