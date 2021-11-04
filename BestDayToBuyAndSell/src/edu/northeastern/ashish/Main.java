package edu.northeastern.ashish;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Main {

    public static void main(String[] args) {
        System.out.println(bestDayToBuyAndSell(new int[]{7,1,5,3,6,4}));
    }

    private static int bestDayToBuyAndSell(int[] arr){
        if(arr == null || arr.length <=1){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = arr[0];

        for(int i = 1 ; i < arr.length; i ++){
            if(arr[i] < minPrice){
                minPrice = arr[i];
            }

            if(maxProfit < arr[i] - minPrice){
                maxProfit = arr[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
