/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/
public void flatten(TreeNode root) {    
    if(root == null)
        return;

    if(root.left != null) {
        flatten(root.left);
        TreeNode p = root.left;
        while(p.right != null) {
            p = p.right;
        }
        TreeNode preRightNode = root.right;
        p.right = preRightNode;
        root.right = root.left;
        root.left = null;
        flatten(preRightNode);
    } else {
        flatten(root.right);
    }
}
