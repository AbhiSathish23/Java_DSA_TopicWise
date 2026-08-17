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
        int[] arr = {-2, -2, 0, 0, 2, 2};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] array) {
        int[] sortedArr = Arrays.stream(array).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < sortedArr.length; i++) {
            if (i > 0 && sortedArr[i] == sortedArr[i - 1]) {
                continue; // skip duplicate 'fixed' value
            }
            int fixed = i;
            int left = fixed + 1;
            int right = sortedArr.length - 1;
            while (left < right) {
                int sum = sortedArr[fixed] + sortedArr[left] + sortedArr[right];
                if (sum == 0) {
                    result.add(Arrays.asList(sortedArr[fixed], sortedArr[left], sortedArr[right]));
                    left++;
                    right--;
                    while (left < right && sortedArr[left] == sortedArr[left - 1]) {
                        left++;
                    }
                    while (left < right && sortedArr[right] == sortedArr[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}


