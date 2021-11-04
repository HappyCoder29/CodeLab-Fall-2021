package edu.northeastern.ashish;
//https://leetcode.com/problems/sign-of-the-product-of-an-array/
public class Main {

    public static void main(String[] args) {

        System.out.println(signOfProducts(new int[] {-1,-2,-3,-4,3,2,1}));
    }

    private  static  int signOfProducts(int[] arr){
        if(arr == null || arr.length == 0 ){
            return  0;
        }

        long product = 1;
        for (int i : arr) {
            product *= i;
        }
        if(product < 0){
            return  -1;
        }
        else if (product > 0){
            return 1;
        }

        return 0;

    }
}
