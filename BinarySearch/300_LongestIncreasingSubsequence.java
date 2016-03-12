/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/
public int lengthOfLIS(int[] nums) {
    if(nums == null || nums.length == 0)
        return 0;
    int[] largerNumsBehind = new int[nums.length];
    largerNumsBehind[nums.length-1] = 1;
    for(int i = nums.length-2; i>= 0; i--) {
        int curCount = 0;
        for(int j = i+1; j < nums.length; j++) {
            if(nums[j] > nums[i]) {
                curCount = Math.max(curCount, largerNumsBehind[j]);
            }
        }
        largerNumsBehind[i] = curCount + 1;
    }

    int res = 0;
    for(int i = 0; i < largerNumsBehind.length; i++) {
        res = Math.max(res, largerNumsBehind[i]);
    }
    return res;

}
