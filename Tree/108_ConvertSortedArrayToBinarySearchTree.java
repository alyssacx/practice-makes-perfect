/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0)
        return null;

    return genBST(nums, 0, nums.length-1);
}

private TreeNode genBST(int[] nums, int start, int end) {
    if(start > end)
        return null;

    int mid = (start+end)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = genBST(nums, start, mid-1);
    root.right = genBST(nums, mid+1, end);
    return root;
}
