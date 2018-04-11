package io.lynna.leetcode;

/**
 * Created by lynna on 2018/3/12.
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target)
    {

        int start = 0;
        int end = nums.length -1 ;
        return searchInsert(start, end, nums, target);
    }

    public static int searchInsert(int start, int end, int[] nums, int target)
    {
        if( target <= nums[0]){
            return 0;
        }
        if(target > nums[end])
            return end+1;
        if(target == nums[end])
            return end;
        if(start == end || ((end-start)==1 && target>nums[start] && target<nums[end]))
            return start+1;
        int mid = start + (end-start)/2;
        if(target > nums[mid]){
            return searchInsert(mid, end, nums, target);
        }else if(target < nums[mid]){
            return searchInsert(start,mid,nums,target);
        }else if(target == nums[mid]){
            return mid;
        }
        return -1;
    }

    public static void insertion_sort(int[] arr)
    {
        int index,temp;
        for( int i=1; i<arr.length; i++ ) {
            index = searchInsert(0, i-1, arr, arr[i]);

            System.out.println("index:"+index);

            for(int j = i;j>index;j--){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
            for (int anArr : arr) {
                System.out.println(anArr);
            }
        }


    }
    public static void main(String args[]){
        int[] test = new int[]{1,9,5,7,3};

        insertion_sort(test);

    }
}
