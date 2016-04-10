/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/
public int numSquares(int n) {

    if(n == 1)
        return 1;

    List<Integer> list = new ArrayList<Integer>();
    for(int i = 1; i <= n/2; i++) {
        int val = i * i;
        if(val == n)
            return 1;
        else if (val < n) {
            list.add(val);
        } else {
            break;
        }
    }

    List<Integer> item = new ArrayList<Integer>();
    helper(n, list, 0, 0, item);
    return item.get(0);
}

private void helper(int n, List<Integer> list, int index, int count, List<Integer> item) {

    if(n < 0)
        return;

    if(n == 0) {
        if(item.size() == 0) {
            item.add(count);
        } else {
            item.set(0, Math.min(item.get(0), count));
        }
    }

    for(int i = index; i < list.size(); i++) {
        helper(n-list.get(i), list, index, count+1, item);
    }
}
