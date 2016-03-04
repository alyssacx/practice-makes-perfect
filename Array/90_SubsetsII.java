/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0)
        return list;
    Arrays.sort(nums);
    int lastSize = 0;
    list.add(new ArrayList<Integer>());
    for(int i = 0; i < nums.length; i++) {
        int size = list.size();
        if(i > 0 && nums[i] != nums[i-1]) {
            lastSize = 0;
        }
        for(int j = lastSize; j < size; j++) {
            List<Integer> item = new ArrayList<Integer>(list.get(j));
            item.add(nums[i]);
            list.add(item);
        }
        lastSize = size;
    }
    return list;

}
