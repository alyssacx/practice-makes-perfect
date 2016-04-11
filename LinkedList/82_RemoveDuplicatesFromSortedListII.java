/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

public ListNode deleteDuplicates(ListNode head) {

    if(head == null || head.next == null)
        return head;

    ListNode helper = new ListNode(0);
    helper.next = head;
    ListNode pre = helper;
    ListNode curNode = head;
    ListNode nextNode = curNode;
    while(nextNode != null) {
        if(nextNode.val != curNode.val) {
            if(curNode.next == nextNode) {
                pre = pre.next;
            } else {
                pre.next = nextNode;
            }
            curNode = nextNode;
        }
        nextNode = nextNode.next;
    }

    if(curNode.next != nextNode) {
        pre.next = nextNode;
    }
    return helper.next;
}
