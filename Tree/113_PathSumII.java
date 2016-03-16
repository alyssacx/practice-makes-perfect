/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(root == null)
        return list;
    calculateSum(root, sum, new ArrayList<Integer>(), list);
    return list;
}

private void calculateSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> list) {
    if(sum == root.val && root.left == null && root.right == null) {
        path.add(root.val);
        list.add(new ArrayList<Integer>(path));
        path.remove(path.size()-1);
        return;
    }
    if(root.left == null && root.right == null)
        return;

    path.add(root.val);
    if(root.left != null) {
        calculateSum(root.left, sum-root.val, path, list);
    }

    if(root.right != null) {
        calculateSum(root.right, sum-root.val, path, list);
    }
    path.remove(path.size()-1);
}
