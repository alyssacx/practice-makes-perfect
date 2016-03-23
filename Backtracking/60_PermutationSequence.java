/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
*/
public String getPermutation(int n, int k) {

    boolean[] used = new boolean[n];
    List<String> list = new ArrayList<String>();
    list.add("");
    permute(n, used, k, 0, 1, 1, n, "", list);
    return list.get(0);
}

private void permute(int n, boolean[] used, int k, int totalNum, int count, int val, int remaining, String res, List<String> list) {

    if(list.get(0).length() == n)
        return;

    if(res.length() == n) {
        list.set(0, res);
        return;
    }

    if(totalNum != 0 && k > totalNum) {
        return;
    }

    k = k - (count-1) * val;

    val = 1;
    for(int i = 1; i < remaining; i++) {
        val *= i;
    }

    int num = 0;
    for(int i = 1; i <= n; i++) {
        if(!used[i-1]) {
            num++;
            used[i-1] = true;
            permute(n, used, k, num * val, num, val, remaining-1, res + Integer.toString(i), list);
            used[i-1] = false;
        }
    }
}
