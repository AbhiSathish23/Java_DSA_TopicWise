package Greddy_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Activity_Selection {

    public static void main(String[] args) {

//        sortedActivity();
        notSortedActivity();
    }

    private static void sortedActivity() {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};   // EndTime is in ASC order

        int maxActivity = 1;
        int lastEnd = end[0];
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1; i < end.length; i++) {
            if (start[i] > lastEnd) {
                maxActivity++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println(maxActivity);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }

    private static void notSortedActivity() {
        int[] start = {5, 8, 5, 0, 3, 1};
        int[] end = {9, 9, 7, 6, 4, 2}; // EndTime is not sorted

        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        int maxActivity = 1;
        int lastEndTime = activities[0][2];
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1; i < start.length; i++) {
            if (activities[i][1] > lastEndTime) {
                maxActivity++;
                ans.add(i);
                lastEndTime = activities[i][2];
            }
        }

        System.out.println(maxActivity);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}


