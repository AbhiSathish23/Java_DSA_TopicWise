package Arrays;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 6, 3, 2, 5};
        int[] maxLeft = maxLeft(height);
        int[] maxRight = maxRight(height);
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(maxLeft[i], maxRight[i]);
            trappedWater += waterLevel - height[i];
        }
        System.out.println(trappedWater);
    }

    private static int[] maxRight(int[] height) {
        int[] maxRight = new int[height.length];
        int n = height.length;
        for (int i = n - 2; i >= 0; i--) {
            maxRight[n - 1] = height[n - 1];
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        return maxRight;
    }

    private static int[] maxLeft(int[] height) {
        int[] maxLeft = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[0] = height[0];
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        return maxLeft;
    }
}
