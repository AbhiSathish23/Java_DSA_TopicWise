package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,5,5,7,8};
        System.out.print(Arrays.toString(twoSum(nums, 9)));
        System.out.print(duplicates(nums));

    }
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)){
                return new int[]{seen.get(complement),i};
            }
            seen.put(nums[i],i);
        }
        return new int[]{};
    }


    // given an array of integers, return true if any value appears at least twice, false if every element is distinct.

    public static boolean duplicates(int[] numbers){
        HashSet<Integer> seen = new HashSet<>();
        for(int i =0 ; i < numbers.length; i++){
            if (seen.contains(numbers[i])){
                return true;
            }
            seen.add(numbers[i]);
        }
        return false;
    }
}
