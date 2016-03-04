/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0)
        return list;
    Arrays.sort(nums);
    list.add(new ArrayList<Integer>());
    for(int i = 0; i < nums.length; i++) {
        int size = list.size();
        for(int j = 0; j < size; j++) {
            List<Integer> item = new ArrayList<Integer>(list.get(j));
            item.add(nums[i]);
            list.add(item);
        }
    }
    return list;
}
