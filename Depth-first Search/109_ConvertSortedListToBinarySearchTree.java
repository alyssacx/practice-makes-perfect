/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public TreeNode sortedListToBST(ListNode head) {

    return buildTree(head, null);
}

private TreeNode buildTree(ListNode head, ListNode tail) {

    if(head == null || head == tail)
        return null;

    ListNode p1 = head;
    ListNode p2 = head;
    while(p2.next != tail && p2.next.next != tail) {
        p1 = p1.next;
        p2 = p2.next.next;
    }

    TreeNode root = new TreeNode(p1.val);
    root.left = buildTree(head, p1);
    root.right = buildTree(p1.next, tail);
    return root;
}
