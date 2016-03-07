/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public int[] searchRange(int[] nums, int target) {
    int[] res = {-1, -1};
    int start = 0;
    int end = nums.length-1;
    int index = -1;
    while(start <= end) {
        int mid = (start+end)/2;
        if(nums[mid] == target) {
            index = mid;
            break;
        } else if(nums[mid] > target) {
            end = mid-1;
        } else {
            start = mid+1;
        }
    }

    if(index == -1) {
        return res;
    }

    int lStart = 0;
    int lEnd = index-1;
    while(lStart <= lEnd) {
        int mid = (lStart+lEnd)/2;
        if(nums[mid] == target) {
            lEnd = mid-1;
        } else {
            lStart = mid+1;
        }
    }
    res[0] = lStart;

    int rStart = index+1;
    int rEnd = nums.length-1;
    while(rStart <= rEnd) {
        int mid = (rStart+rEnd)/2;
        if(nums[mid] == target) {
            rStart = mid+1;
        } else {
            rEnd = mid-1;
        }
    }
    res[1] = rEnd;
    return res;
}
