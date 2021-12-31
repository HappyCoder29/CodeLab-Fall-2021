package edu.northeastern.ashish;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    public static long[] values = new long[50000040];

    public static long[] portionSum = new long[Runtime.getRuntime().availableProcessors()];

    public static int portionSize = values.length / Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
//        PrintThread pt = new PrintThread();
//        pt.name = "Ashish";
//        Thread th = new Thread(pt);
//        th.setPriority(Thread.MAX_PRIORITY);
//        th.start();
//
//        PrintThread pt1 = new PrintThread();
//        pt1.name = "Cun Mu";
//        Thread th1 = new Thread(pt1);
//        th1.setPriority(Thread.MIN_PRIORITY);
//        th1.start();
//
//        simpleFunc();

        generateValues();
        System.out.println(Runtime.getRuntime().availableProcessors());

        Instant starts = Instant.now();
        long sum = getSum();
        Instant ends = Instant.now();
        System.out.println("Sum = " + sum);
        System.out.println(" Time taken = " + Duration.between(starts, ends).toMillis() + " milli seconds");


        starts = Instant.now();
        Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];


        for(int i = 0 ; i < threads.length; i ++){
            threads[i] = new Thread(new CalculateSum(i));
            threads[i].start();
        }

        // Wait for threads to finish calculating sum
        for(int i = 0 ; i < threads.length; i ++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sum = 0 ;
        // At this point all the threads have completed
        for(int i = 0; i < Runtime.getRuntime().availableProcessors(); i ++){
            sum += portionSum[i];
        }

        ends = Instant.now();
        System.out.println("Sum = " + sum);
        System.out.println(" Time taken = " + Duration.between(starts, ends).toMillis() + " milli seconds");



    }

    private static void generateValues(){
        Random rand = new Random();
        for(int i = 0 ; i < values.length; i ++){
            values[i] = rand.nextInt(10);
        }
    }

    private static long getSum(){
        long sum = 0;
        for(int i = 0 ; i < values.length; i ++){
            sum +=  values[i];
        }
        return sum;
    }

    private static void simpleFunc(){
        for(int i = 0 ; i < 10; i ++){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
