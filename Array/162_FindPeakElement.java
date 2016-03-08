/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Note:
Your solution should be in logarithmic complexity.
*/
public int findPeakElement(int[] nums) {
    int start = 0;
    int end = nums.length-1;
    while(end - start > 1) {
        int mid = (start+end)/2;
        if(nums[mid] < nums[mid+1]) {
            start = mid;
        } else {
            end = mid;
        }
    }
    return nums[end]>=nums[start]? end: start;
}

public int findPeakElement(int[] nums) {
    for(int i = 1; i < nums.length; i++) {
        if(nums[i] < nums[i-1]) {
            return i-1;
        }
    }
    return nums.length-1;
}
