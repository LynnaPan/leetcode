package io.lynna.leetcode;

import java.util.Arrays;

/**
 * Created by lynna on 2017/12/6.
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] leftScan = new int[ratings.length];
        Arrays.fill(leftScan, 1);

        //from left to right
        for(int i=0;i<ratings.length-1; i++){
            if(ratings[i+1]>ratings[i]){
                leftScan[i+1] = leftScan[i]+1;
            }
        }

        int[] rightScan = new int[ratings.length];
        Arrays.fill(rightScan, 1);

        //from right to left
        for(int i = ratings.length-1; i>0; i--) {
            if(ratings[i-1] > ratings[i]){
                rightScan[i - 1] = rightScan[i]+1;
            }
        }

        int sum = 0;
        for(int i=0;i<ratings.length;i++){
            rightScan[i] = Math.max(leftScan[i], rightScan[i]);
            sum = sum + rightScan[i];
        }

        return sum;

    }
}
