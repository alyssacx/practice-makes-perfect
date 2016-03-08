/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
public List<List<Integer>> combinationSum3(int k, int n) {      
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    combine(k, n, new ArrayList<Integer>(), list, 1);
    return list;
}

private void combine(int k, int n, List<Integer> item, List<List<Integer>> list, int num) {
    if(n == 0 && k == 0) {
        list.add(new ArrayList<Integer>(item));
        return;
    }

    if(n < 0 || k < 0) {
        return;
    }

    for(int i = num; i <= 9; i++) {
        item.add(i);
        combine(k-1, n-i, item, list, i+1);
        item.remove(item.size()-1);
    }
}
