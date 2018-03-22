package io.lynna.leetcode;

/**
 * Created by lynna on 2018/3/22.
 */


class MedianOfTwoSort {
    class Pair {
        public int[] array;
        public int index;

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //make sure m<n
        if(m>n){
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        if(n==0)
            return 0.0;
        if(n==1){
            if(m == 1)
                return (nums1[0]+nums2[0])/2.0;
            else
                return nums2[0];
        }
        if(m==0){
            if(n%2==0)
                return (nums2[n/2-1]+nums2[n/2])/2.0;
            else
                return nums2[n/2];
        }


        int totalLength = m + n;
        int iMin = 0, iMax = m, half = (totalLength+1)/2;
        int index_m, index_n;
        while(iMin <= iMax){
            //seperate two list into two buckets
            index_m = (iMin+iMax)/2;
            index_n = half - index_m;
            if(index_m < m && nums1[index_m] < nums2[index_n-1])
                iMin = index_m + 1;
            else if(index_m > 0 && nums1[index_m-1] > nums2[index_n])
                iMax = index_m -1;

            else{
                int maxLeft, minRight;
                if(index_m==0){
                    maxLeft = nums2[index_n - 1];
                }else if(index_n == 0){
                    maxLeft = nums1[index_m - 1];
                }else{
                    maxLeft = Math.max(nums1[index_m-1], nums2[index_n-1]);
                }

                if(totalLength%2 == 1)
                    return maxLeft;

                if(index_m == m)
                    minRight = nums2[index_n];
                else if(index_n == n)
                    minRight = nums1[index_m];
                else
                    minRight = Math.min(nums1[index_m], nums2[index_n]);

                System.out.println(maxLeft);
                System.out.println(minRight);

                return (maxLeft+minRight)/2.0;


            }


        }
        return 0.0;
    }

    public static void main(String args[]){
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1,2,3,4,5};

        MedianOfTwoSort test = new MedianOfTwoSort();
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}