/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
*/
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if(root == null)
        return null;

    if(root == p || root == q)
        return root;

    if(root.left == p) {
        boolean leftHas = findAncestor(root.left, q);
        boolean rightHas = findAncestor(root.right, q);
        if(leftHas) {
            return p;
        } else {
            return root;
        }
    }

    if(root.right == p) {
        boolean leftHas = findAncestor(root.left, q);
        boolean rightHas = findAncestor(root.right, q);
        if(rightHas) {
            return p;
        } else {
            return root;
        }
    }

    if(root.left == q) {
        boolean leftHas = findAncestor(root.left, p);
        boolean rightHas = findAncestor(root.right, p);
        if(leftHas) {
            return q;
        } else {
            return root;
        }
    }

    if(root.right == q) {
        boolean leftHas = findAncestor(root.left, p);
        boolean rightHas = findAncestor(root.right, p);
        if(rightHas) {
            return q;
        } else {
            return root;
        }
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if(left != null && right != null) {
        return root;
    }
    return left == null ? right: left;
}

private boolean findAncestor(TreeNode root, TreeNode node) {

    if(root == null)
        return false;

    if(root.left == node || root.right == node)
        return true;

    return findAncestor(root.left, node) || findAncestor(root.right, node);
}

/***********************************/
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if(root == null)
        return null;

    if(root == p || root == q)
        return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if(left != null && right != null) {
        return root;
    }
    return left == null ? right: left;
}
