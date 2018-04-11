package io.lynna.leetcode;

/**
 * Created by lynna on 2018/4/11.
 */


class MergeSort {
    public void MergeSortArray(int[] nums){
        int length = nums.length;
        if(length <=1)
            return;
        int[] result = new int[length];
        MergeSortArray(nums, result, 0 , length-1);

    }

    public void MergeSortArray(int[] nums, int[] result, int start, int end){
        if(start >= end)
            return;
        int len = end - start;
        int mid = start + len/2;
        int start1 = 0;
        int end1 = mid;
        int start2 = mid+1;
        int end2 = end;
        MergeSortArray(nums, result, start1, end1);
        MergeSortArray(nums, result, start2, end2);

        int index = start;
        while(start1 < end1 && start2 < end2){
            result[index++] = (nums[start1] < nums[start2]) ? nums[start1++] :nums[start2++];
        }
        while(start1 <= end1)
            result[index++] = nums[start1++];
        while(start2 <= end2)
            result[index++] = nums[start2++];
        for (int i = 0; i< len; i++){
            nums[i] = result[i];
        }

    }

    public static void main(String args[]){
        int[] test = {6,3,7,2,9,8,1,15};

        MergeSort(test);
        System.out.println(test);

    }
}



