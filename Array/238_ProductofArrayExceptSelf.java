/**
Product of Array Except Self

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
**/

public int[] productExceptSelf(int[] nums) {
    int[] left = new int[nums.length];
    left[0] = 1;
    int[] right = new int[nums.length];
    right[nums.length-1] = 1;

    int[] res = new int[nums.length];

    for(int i = 1; i < nums.length; i++) {
        left[i] = left[i-1] * nums[i-1];
    }

    for(int i = nums.length-2; i >=0; i--) {
        right[i] = right[i+1] * nums[i+1];
    }

    for(int i = 0; i < nums.length; i++) {
        res[i] = left[i] * right[i];
    }

    return res;
}

//solve it with constant space
public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    res[0] = 1;

    for(int i = 1; i < nums.length; i++) {
        res[i] = res[i-1] * nums[i-1];
    }

    int right = 1;
    for(int i = nums.length-2; i >=0; i--) {
        right = right * nums[i+1];
        res[i] = res[i] * right;
    }
    return res;
}
