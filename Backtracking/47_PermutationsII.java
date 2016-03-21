/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0)
        return list;

    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    permute(nums, visited, new ArrayList<Integer>(), list);
    return list;
}

private void permute(int[] nums, boolean[] visited, List<Integer> item, List<List<Integer>> list) {
    if(item.size() == nums.length) {
        list.add(new ArrayList<Integer>(item));
        return;
    }

    for(int i = 0; i < nums.length; i++) {
        if(!visited[i]) {
            if(i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
                continue;
            }
            item.add(nums[i]);
            visited[i] = true;
            permute(nums, visited, item, list);
            visited[i] = false;
            item.remove(item.size()-1);
        }
    }
}
