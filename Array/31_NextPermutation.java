/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
public void nextPermutation(int[] nums) {

    if(nums == null || nums.length <= 1)
        return;

    int i = nums.length-2;
    while(i >= 0) {
        if(nums[i] < nums[i+1]) {
            break;
        }
        i--;
    }

    if(i == -1) {
        reverseNums(nums, 0, nums.length-1);
        return;
    }

    int j = i+1;
    while(j < nums.length) {
        if(nums[j] <= nums[i]) {
            break;
        }
        j++;
    }
    j = j-1;
    swapNums(nums, i, j);
    reverseNums(nums, i+1, nums.length-1);
}

private void swapNums(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

private void reverseNums(int[] nums, int start, int end) {
    while(start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }    
}
