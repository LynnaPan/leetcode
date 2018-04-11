package io.lynna.leetcode;

import java.util.Arrays;

/**
 * Created by lynna on 2017/12/10.
 */
public class KthSmallestPair {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1]-nums[0];

        while(low < high) {
            int mid = (high + low) / 2;
            int left = 0;
            int count = 0;
            for(int right = 1; right < nums.length; right++){
                while(nums[right]-nums[left]>mid) left++;
                count +=  right - left;
            }
            if(k == count)
                return mid;
            else if(k<count)
                high = mid;
            else
                low = mid+1;
        }
        return low;
    }

}
