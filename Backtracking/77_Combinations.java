/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public List<List<Integer>> combine(int n, int k) {

    List<List<Integer>> list = new ArrayList<List<Integer>>();
    helper(n, 1, k, new ArrayList<Integer>(), list);
    return list;
}

private void helper(int n, int index, int k, List<Integer> item, List<List<Integer>> list) {

    if(item.size() == k) {
        list.add(new ArrayList<Integer>(item));
        return;
    }

    for(int i = index; i <= n; i++) {
        item.add(i);
        helper(n, i+1, k, item, list);
        item.remove(item.size()-1);
    }
}
