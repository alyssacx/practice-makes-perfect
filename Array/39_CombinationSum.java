/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
*/
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(candidates == null || candidates.length == 0)
        return list;
    Arrays.sort(candidates);
    findCombination(candidates, target, 0, new ArrayList<Integer>(), list);
    return list;
}

private void findCombination(int[] candidates, int target, int index, List<Integer> item, List<List<Integer>> list) {
    if(target == 0) {
        list.add(new ArrayList<Integer>(item));
        return;
    }

    if(target < 0) {
        return;
    }

    for(int i = index; i < candidates.length; i++) {
        item.add(candidates[i]);
        findCombination(candidates, target-candidates[i], i, item, list);
        item.remove(item.size()-1);
    }
}
