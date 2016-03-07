/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public TreeNode buildTree(int[] inorder, int[] postorder) {
    return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
}

private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
    if(inStart > inEnd)
        return null;
    int rootIndex = findIndex(inorder, postorder[poEnd]);
    TreeNode root = new TreeNode(postorder[poEnd]);
    int leftTreeLen = rootIndex-inStart;
    root.left = build(inorder, inStart, rootIndex-1, postorder, poStart, poStart+leftTreeLen-1);
    root.right = build(inorder, rootIndex+1, inEnd, postorder, poStart+leftTreeLen, poEnd-1);
    return root;
}

private int findIndex(int[] inorder, int num) {
    for(int i = 0; i < inorder.length; i++) {
        if(inorder[i] == num)
            return i;
    }
    return -1;
}
