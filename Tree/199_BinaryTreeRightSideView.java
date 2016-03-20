/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

*/
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    if(root == null)
        return list;

    getView(root, list, 0);
    return list;
}

private void getView(TreeNode root, List<Integer> list, int level) {

    if(root == null)
        return;

    if(list.size() <= level) {
        list.add(root.val);
    }
    getView(root.right, list, level+1);
    getView(root.left, list, level+1);
}
