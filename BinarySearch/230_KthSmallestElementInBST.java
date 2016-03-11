/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).

*/
public int kthSmallest(TreeNode root, int k) {
    List<Integer> res = new ArrayList<Integer>();
    List<TreeNode> p = new ArrayList<TreeNode>();
    res.add(0);
    helper(root, k, res, p);
    return p.get(0).val;
}

private void helper(TreeNode root, int k, List<Integer> res, List<TreeNode> p) {
    if(root == null || p.size() != 0)
        return;

    helper(root.left, k, res, p);
    if(k == res.get(0) + 1) {
        p.add(root);
        return;
    }
    res.set(0, res.get(0) + 1);
    helper(root.right, k, res, p);
}
