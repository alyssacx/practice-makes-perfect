/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
public List<List<Integer>> permute(int[] nums) {      
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0)
        return list;
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
            visited[i] = true;
            item.add(nums[i]);
            permute(nums, visited, item, list);
            visited[i] = false;
            item.remove(item.size()-1);
        }
    }
}
