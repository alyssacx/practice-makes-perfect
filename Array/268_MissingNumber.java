/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
public int missingNumber(int[] nums) {
    int index = nums.length;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != i) {
            if(nums[i] < nums.length) {
                swapNums(nums, i, nums[i]);
                i--;
            }
        }
    }
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != i)
            return i;
    }
    return nums.length;
}

private void swapNums(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
