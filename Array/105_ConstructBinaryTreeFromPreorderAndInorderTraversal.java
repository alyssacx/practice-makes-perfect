/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
}

private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    if(preStart > preEnd)
        return null;
    int rootIndex = findIndex(inorder, preorder[preStart]);
    TreeNode root = new TreeNode(preorder[preStart]);
    int leftTreeLen = rootIndex-inStart;
    root.left = build(preorder, preStart+1, preStart+leftTreeLen, inorder, inStart, rootIndex-1);
    root.right = build(preorder, preStart+leftTreeLen+1, preEnd, inorder, rootIndex+1, inEnd);
    return root;
}

private int findIndex(int[] inorder, int num) {
    for(int i = 0; i < inorder.length; i++) {
        if(inorder[i] == num)
            return i;
    }
    return -1;

}
