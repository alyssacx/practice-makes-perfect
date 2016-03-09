/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return list;
        Arrays.sort(nums);
        for(int i = nums.length-1; i>2; i--) {
            if(i < nums.length-1 && nums[i] == nums[i+1]) {
                continue;
            }
            List<List<Integer>> res = threeSum(nums, i-1, target-nums[i]);
            for(int j = 0; j < res.size(); j++) {
                res.get(j).add(nums[i]);
            }
            list.addAll(res);
        }
        return list;
    }

    private List<List<Integer>> threeSum(int[] nums, int end, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = end; i > 1; i--) {
            if(i < end && nums[i] == nums[i+1]) {
                continue;
            }
            List<List<Integer>> res = twoSum(nums, i-1, target-nums[i]);
            for(int j = 0; j < res.size(); j++) {
                res.get(j).add(nums[i]);
            }
            list.addAll(res);
        }
        return list;
    }

    private List<List<Integer>> twoSum(int[] nums, int end, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int start = 0;
        while(start < end) {
            if(nums[start] + nums[end] == target) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(nums[start++]);
                item.add(nums[end--]);
                list.add(item);
                while(start < end && nums[start] == nums[start-1])
                    start++;
                while(start < end && nums[end] == nums[end+1])
                    end--;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return list;
    }
