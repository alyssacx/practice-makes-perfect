/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
public boolean isValidBST(TreeNode root) {
    return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

private boolean isValid(TreeNode root, int min, int max) {
    if(root == null)
        return true;

    if(root.val > max || root.val < min)
        return false;

    if(root.val == Integer.MAX_VALUE) {
        if(root.right != null)
            return false;
        return isValid(root.left, min, root.val-1);
    }

    if(root.val == Integer.MIN_VALUE) {
        if(root.left != null)
            return false;
        return isValid(root.right, root.val+1, max);
    }

    return isValid(root.left, min, root.val-1) && isValid(root.right, root.val+1, max);
}
