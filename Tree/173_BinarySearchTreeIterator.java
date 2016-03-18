/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    int nextVal;
    public boolean hasNext() {
        if(!stack.isEmpty()) {
            TreeNode p = stack.pop();
            nextVal = p.val;
            p = p.right;
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
            return true;
        }
        return false;

    }

    /** @return the next smallest number */
    public int next() {
        return nextVal;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
