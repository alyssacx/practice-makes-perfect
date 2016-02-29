/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                if(nums[left] + nums[right] == subTarget)
                    return target;
                else {
                    int currentClose = Math.abs(nums[left] + nums[right] - subTarget);
                    if(currentClose < close) {
                        close = currentClose;
                        sum = nums[left] + nums[right] + nums[i];
                    }
                    if(nums[left] + nums[right] < subTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return sum;
}


public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int curSum = nums[left] + nums[right] + nums[i];
                int diff = Math.abs(curSum - target);
                if(diff == 0)
                    return target;
                else {
                    if(diff < close) {
                        close = diff;
                        sum = curSum;
                    }
                    if(curSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return sum;
}
