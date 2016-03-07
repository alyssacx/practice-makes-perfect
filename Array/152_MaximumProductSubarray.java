/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
public int maxProduct(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    int global = nums[0];
    for(int i = 1; i < nums.length; i++) {
        int localMin = Math.min(Math.min(max*nums[i], min*nums[i]), nums[i]);
        int localMax = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
        min = localMin;
        max = localMax;
        global = Math.max(max, global);
    }
    return global;
}
