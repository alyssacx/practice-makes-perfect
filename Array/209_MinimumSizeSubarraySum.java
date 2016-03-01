/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
public int minSubArrayLen(int s, int[] nums) {
    if(nums == null || nums.length == 0)
        return 0;

    int left = 0;
    int right = 0;
    int len = nums.length+1;
    int sum = 0;

    while(right < nums.length) {
        sum += nums[right];
        while(sum >= s) {
            len = Math.min(len, right-left+1);
            sum = sum - nums[left];
            if(left == right) {
                right++;
            }
            left++;
        }
        right++;
    }
    return left == 0? 0: len;
}
