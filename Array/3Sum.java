/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return list;

        Arrays.sort(nums);
        for(int i = nums.length-1; i >= 2; i--) {
            if(i < nums.length-1 && nums[i] == nums[i+1])
                continue;
            List<List<Integer>> res = twoSum(0, i-1, nums, -nums[i]);
            for(int j = 0; j < res.size(); j++) {
                res.get(j).add(nums[i]);
            }
            list.addAll(res);
        }
        return list;
    }

    private List<List<Integer>> twoSum(int left, int right, int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                List<Integer> item = new ArrayList<Integer>();
                item.add(nums[left]);
                item.add(nums[right]);
                list.add(item);
                left++;
                right--;
                while(left < right && nums[left] == nums[left-1])
                    left++;
                while(left < right && nums[right] == nums[right+1])
                    right--;
            } else if (nums[left] + nums[right] > target) {
                right--;
                while(left < right && nums[right] == nums[right+1])
                    right--;
            } else {
                left++;
                while(left < right && nums[left] == nums[left-1])
                    left++;
            }
        }
        return list;
    }
