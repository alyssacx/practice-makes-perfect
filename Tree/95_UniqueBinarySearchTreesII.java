/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public List<TreeNode> generateTrees(int n) {
    List<TreeNode> list = new ArrayList<TreeNode>();
    if(n == 0)
        return list;
    return generate(1, n);
}

public List<TreeNode> generate(int start, int end) {
    List<TreeNode> list = new ArrayList<TreeNode>();
    if(start > end) {
        list.add(null);
        return list;
    }

    for(int i= start; i <= end; i++) {
        List<TreeNode> left = generate(start, i-1);
        List<TreeNode> right = generate(i+1, end);

        for(int j = 0; j < left.size(); j++) {
            for(int k = 0; k < right.size(); k++) {
                TreeNode root = new TreeNode(i);
                root.left = left.get(j);
                root.right = right.get(k);
                list.add(root);
            }
        }
    }
    return list;
}
