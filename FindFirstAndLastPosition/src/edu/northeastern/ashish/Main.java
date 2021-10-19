package edu.northeastern.ashish;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class Main {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] result = findFirstAndLast(arr, 8);
        if(result != null){
            System.out.println("First Position = " + result[0]);
            System.out.println("Last Position = " + result[1]);
        }else{
            System.out.printf("Element not found");
        }
    }

    private static int[]  findFirstAndLast(int[] arr, int x){
        if(arr == null){
            return  null;
        }

        int firstIndex = findFirstPosition(arr, x);

        if(firstIndex == -1){
            return null;
        }

        int lastIndex = findLastPosition(arr, x);

        return new int[]{firstIndex, lastIndex};
    }





    public static int findFirstPosition(int[] arr, int x){
        return findFirstPosition(arr, x, 0, arr.length -1);
    }
    private static int findFirstPosition(int[] arr, int x, int low, int high){
        if(low > high){
            return -1;
        }
        if(arr[high] < x){
            return -1;
        }
        if(arr[low] > x){
            return -1;
        }
        if(arr[low] == x && arr[high] == x){
            return low;
        }

        int mid = (low + high)/2;

        if(arr[mid] < x){
            return findFirstPosition(arr, x, mid +1, high);
        }else if (arr[mid] > x){
            return findFirstPosition(arr, x, low, mid -1);
        }else{
            return findFirstPosition(arr, x, low, mid -1) ;
        }
    }


    public static int findLastPosition(int[] arr, int x){
        return findLastPosition(arr, x, 0, arr.length -1);
    }
    private static int findLastPosition(int[] arr, int x, int low, int high){
        if(low > high){
            return -1;
        }
        if(arr[high] < x){
            return -1;
        }
        if(arr[low] > x){
            return -1;
        }
        if(arr[low] == x && arr[high] == x){
            return low;
        }

        int mid = (low + high)/2;

        if(arr[mid] < x){
            return findLastPosition(arr, x, mid +1, high);
        }else if (arr[mid] > x){
            return findLastPosition(arr, x, low, mid -1);
        }else{
            return findLastPosition(arr, x, mid, high -1  ) ;
        }
    }
}
