/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

public ListNode reverseBetween(ListNode head, int m, int n) {

    if(head == null || head.next == null)
        return head;

    ListNode helper = new ListNode(0);
    helper.next = head;
    ListNode before = helper;
    int count = 1;
    ListNode p = head;
    while(count < m) {
        before = before.next;
        p = p.next;
        count++;
    }
    before.next = null;
    ListNode first = p;
    while(count < n) {
        p = p.next;
        count++;
    }
    ListNode after = p.next;
    p.next = null;

    before.next = reverse(first, after);
    return helper.next;
}

private ListNode reverse(ListNode head, ListNode after) {
    if(head == null)
        return head;

    ListNode pre = after;
    ListNode p = head;
    while(p != null) {
        ListNode temp = p.next;
        p.next = pre;
        pre = p;
        p = temp;
    }
    return pre;
}
