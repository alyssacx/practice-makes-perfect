/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/
public boolean search(int[] nums, int target) {
    int start = 0;
    int end = nums.length-1;
    while(start <= end) {
        int mid = (start + end)/2;
        if(nums[mid] == target)
            return true;

        if (nums[start] <= nums[mid]) {
            if(nums[start] == nums[mid]) {
                start = start +1;
                continue;
            }
            if(nums[start] <= target && target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        } else {
            if(nums[mid] == nums[end]) {
                end = end-1;
                continue;
            }
            if(nums[mid] < target && target <= nums[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
    }
    return false;

}
