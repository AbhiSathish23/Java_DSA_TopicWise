package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    Given an array of integers, find all unique triplets [a, b, c]
     such that a + b + c == 0. Return the list of triplets (no duplicates).
    Example: [-1, 0, 1, 2, -1, -4] → output [[-1, -1, 2], [-1, 0, 1]]
     */
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] array){
       int[] sortedArr = Arrays.stream(array).sorted().toArray();
       List<List<Integer>> result  = new ArrayList<>();

       for (int i=0; i < sortedArr.length; i++) {
           int fixed = i;
           int left = fixed + 1;
           int right = sortedArr.length - 1;
           while (left < right) {
               int sum = sortedArr[fixed] + sortedArr[left] + sortedArr[right];
               if (sum == 0) {
                   result.add(Arrays.asList(sortedArr[fixed], sortedArr[left], sortedArr[right]));
               }
               fixed++;
               left++;
               right--;
           }
       }
       return result;
    }
}
