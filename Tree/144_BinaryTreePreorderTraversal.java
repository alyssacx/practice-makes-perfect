/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

*/
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    if(root == null)
        return list;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if (p != null) {
            list.add(p.val);
            stack.push(p);
            p = p.left;
        } else {
            p = stack.pop();
            p = p.right;
        }
    }
    return list;    
}
