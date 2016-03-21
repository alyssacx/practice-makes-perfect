/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    List<List<Integer>> list = new ArrayList<List<Integer>>();
    if(root == null)
        return list;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int lastLevelCount = 1;
    int curLevelCount = 0;
    boolean reverseFlag = false;
    List<Integer> item = new ArrayList<Integer>();
    while(!queue.isEmpty()) {
        TreeNode p = queue.poll();
        item.add(p.val);
        lastLevelCount--;
        if(p.left != null) {
            queue.add(p.left);
            curLevelCount++;
        }

        if(p.right != null) {
            queue.add(p.right);
            curLevelCount++;
        }

        if(lastLevelCount == 0) {
            if(reverseFlag) {
                Collections.reverse(item);
                reverseFlag = false;
            } else {
                reverseFlag = true;
            }
            lastLevelCount = curLevelCount;
            curLevelCount = 0;
            list.add(item);
            item = new ArrayList<Integer>();
        }
    }
    return list;
}
