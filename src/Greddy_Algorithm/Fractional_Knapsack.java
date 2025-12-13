package Greddy_Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {

    public static void main(String[] args) {


        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;


        double[][] ratio = new double[value.length][2];

        for (int i=0; i<value.length; i++){
            ratio[i][0]=i;
            ratio[i][1]= value[i] / (double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o ->o[1]));


    }

}
