package edu.northeastern.ashish;
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class Main {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        findKthLargest(arr,2);
    }

    // O(n Log n) Average case
    private static void findKthLargest(int[] arr, int k){
        findKthLargest(arr, k, 0, arr.length -1);
    }

    private  static  void findKthLargest(int[] arr, int k, int low, int high){
        if(low <= high){
            int pos = partition (arr, low, high);
            if( pos == arr.length -k ){
                System.out.println("Value = " + arr[pos]);
                return;
            }
            findKthLargest(arr, k ,  low, pos -1);
            findKthLargest(arr, k,  pos +1, high);
        }
    }

    // O(n)
    private static  int partition(int[] arr, int low, int high){

        int pivot = arr[high]; // last element is the pivot
        int wall = low -1;
        for(int i = low; i < high; i ++){
            if(arr[i] < pivot){
                wall ++;
                swap(arr, i, wall);
            }
        }

        wall ++;
        swap(arr, high, wall);
        return wall;
    }


    // O(1)
    private static void swap(int[] arr, int i , int j){
        if(arr == null || i < 0 || i > arr.length -1 || j < 0 || j > arr.length -1){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
