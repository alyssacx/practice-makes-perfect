/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
public ListNode partition(ListNode head, int x) {
    if(head == null)
        return head;
    ListNode largerNode = new ListNode(0);
    ListNode larger_pt = largerNode;
    ListNode smallerNode = new ListNode(0);
    ListNode smaller_pt = smallerNode;
    while(head!= null) {
        if(head.val >= x) {
            larger_pt.next = new ListNode(head.val);
            larger_pt = larger_pt.next;

        } else {
            smaller_pt.next = new ListNode(head.val);
            smaller_pt = smaller_pt.next;
        }
        head = head.next;
    }
    smaller_pt.next = largerNode.next;
    return smallerNode.next;
}
