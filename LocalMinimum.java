package com.java.ninja;

/* Find one local minimum from an array of numbers.
        e.g:
        input: 9, 7, 2, 8, 5, 6, 3, 4
        output: 2 or 5 or 3”
 */
public class LocalMinimum {
    /*
     Solution : Brute-force
     Runtime : O(N), Space : O(1)
     */
    public static int findLocalMinimum(int[] arr){
        if(arr == null || arr.length == 0)
            return Integer.MIN_VALUE;

        int arrSize = arr.length;

        if(arr[0] < arr[1]) // basecase to check if first element is less than second element
            return arr[0];

        if(arr[arrSize - 1] < arr[arrSize - 2]) // if last but one element is less than last element
            return arr[arrSize - 1];

        for(int i = 1; i < arrSize - 1; i++) { // from 1 to n - 1
            if(arr[i] < arr[i - 1] && arr[i] < arr[i + 1])
                return arr[i];
        }
        return Integer.MIN_VALUE;
    }

    /*solution : Binary Search
     Runtime : O(Log N), Space : O(Log N) - recursive call stack
     */
    public static int findLocalMinimumBinarySearch(int[] arr) {
        return findLocalMinimumBinarySearch(arr, 0, arr.length - 1);
    }

    private static int findLocalMinimumBinarySearch(int[] arr, int start, int end){
        int arrSize = arr.length;
        int mid = start + (end - start)/2;

        if(arr[0] < arr[1]) // base-case to check if first element is less than second element
            return arr[0];

        if(arr[arrSize - 1] < arr[arrSize - 2]) // if last but one element is less than last element
            return arr[arrSize - 1];

        if(mid > 0 && arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1])  // note check if mid > 0
            return arr[mid];

        else if( mid > 0 && arr[mid - 1] < arr[mid])
            return findLocalMinimumBinarySearch(arr, start, mid-1);

        return findLocalMinimumBinarySearch(arr, mid+1, end);
    }

    public static void main(String[] args) {

        System.out.println(findLocalMinimum(new int[]{8, 1})); // 1
        System.out.println(findLocalMinimumBinarySearch(new int[]{8, 1})); // 1

        System.out.println(findLocalMinimum(new int[]{9, 6, 3, 14, 5, 7, 4})); // 3
        System.out.println(findLocalMinimumBinarySearch(new int[]{9, 6, 3, 14, 5, 7, 4})); // 3

        System.out.println(findLocalMinimum(new int[]{1, 2, 3})); // 1
        System.out.println(findLocalMinimumBinarySearch(new int[]{1, 2, 3})); //1

        System.out.println(findLocalMinimum(new int[]{3, 2, 1})); // 1
        System.out.println(findLocalMinimumBinarySearch(new int[]{3, 2, 1})); //1

        System.out.println(findLocalMinimum(new int[]{23, 8, 15, 2, 3})); // 8
        System.out.println(findLocalMinimumBinarySearch(new int[]{23, 8, 15, 2, 3})); // 8

        System.out.println(findLocalMinimum(new int[]{64, 14, 52, 27, 71, 19, 63, 1, 16, 57})); //
        System.out.println(findLocalMinimumBinarySearch(new int[]{64, 14, 52, 27, 71, 19, 63, 1, 16, 57})); //
    }

}
