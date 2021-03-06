/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if(i > 0 && i != index && candidates[i] == candidates[i-1])
            continue;
        item.add(candidates[i]);
        findCombination(candidates, target-candidates[i], i+1, item, list);
        item.remove(item.size()-1);
    }
}
