package Sorting;

import java.util.Arrays;
import java.util.Collections;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {2,3,1};
//        bubbleSort(arr);
        selectionSort(arr);
//        insertionSort(arr);
//        inbuiltSort(arr);

//        int[] countSortArr = {1,4,1,3,2,4,3,7};
//        countSort(countSortArr);
    }


    private static void bubbleSort(int[] arr) {
        int n = arr.length - 1;
        for (int turn = 0; turn < n; turn++) {
            for (int j = 0; j < n - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));  // How does toString work?
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            int minPos = i;                        // Why this minPos
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void  insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int curr = i;
            int prev = i-1;

            // finding out the correct pos to insert
            while (prev >=0 && arr[prev] > arr[curr]){
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // insertion
            arr[prev + 1] = curr;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void inbuiltSort(int[] arr){    // O(n log n)
        Arrays.sort(arr);    // Learn how this sort works internally
        Arrays.sort(arr,0,3);
        System.out.println(Arrays.toString(arr));

//        Arrays.sort(arr, Collections.reverseOrder());     ---> this works if arr is nonPrimitive data type
//        Arrays.sort(arr,0,3, Collections.reverseOrder());     ---> this works if arr is nonPrimitive data type
    }

    private static void countSort(int[] arr){
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            largest = Math.max(arr[i],largest);
        }

        int[] count = new int[largest+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j=0;
        for (int i = 0; i <count.length; i++) {
            while (count[i] >0 ){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
