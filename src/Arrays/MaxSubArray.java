package Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
//        kadanesAlgo(arr);
        System.out.println(kadanesAlgo(arr));

    }

    private static int kadanesAlgo(int[] arr) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i < arr.length; i++) {
            currentSum = Math.max(arr[i],currentSum + arr[i]);    // Learn how Math.max() works
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}
