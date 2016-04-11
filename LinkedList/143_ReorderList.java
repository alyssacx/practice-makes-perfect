/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

public void reorderList(ListNode head) {

    if(head == null || head.next == null)
        return;

    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode temp = slow.next;
    slow.next = null;

    ListNode head2 = reverse(temp);
    ListNode p = head;
    while(head2 != null) {
        ListNode next = head2.next;
        head2.next = p.next;
        p.next = head2;
        p = head2.next;
        head2 = next;
    }
}

private ListNode reverse(ListNode head) {
    if(head == null || head.next == null)
        return head;
    ListNode pre = null;
    ListNode p = head;
    while(p != null) {
        ListNode temp = p.next;
        p.next = pre;
        pre = p;
        p = temp;
    }
    return pre;
}
