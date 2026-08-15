package Arrays;


import static java.util.Collections.min;

/*
Problem: given an array height, where height[i] represents a vertical line at position i,
 find two lines that, together with the x-axis,
 form a container that holds the most water. Return the max area.
 */
public class ContainedWater {
    public static void main(String[] args) {
       int[] height = {1,8,6,2,5,4,8,3,7};
       System.out.println(containedWater(height));

    }
    public static int containedWater(int[] height){
        int left = 0;
        int right = height.length - 1;
        int MaxArea = Integer.MIN_VALUE;

        while(left < right){
            int width = right - left;
            int minHeight = Math.min(height[left],height[right]);
            int area = width * minHeight;
            if (area > MaxArea){
                MaxArea = area;
            }
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return MaxArea;
    }
}
