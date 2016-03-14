/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
public ListNode rotateRight(ListNode head, int k) {
    if(head == null || k == 0)
        return head;

    int len = 1;
    ListNode p = head;
    while(p.next != null) {
        p = p.next;
        len++;
    }
    k = k%len;
    if(k == 0)
        return head;

    ListNode q = head;
    int count = 1;
    //find the last node of the new list
    while(count < len-k) {
        q = q.next;
        count++;
    }
    ListNode newHead = q.next;
    q.next = null;
    p.next = head;
    return newHead;
}
