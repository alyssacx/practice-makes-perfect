/*
Sort a linked list in O(n log n) time using constant space complexity.
*/
public ListNode sortList(ListNode head) {

    return sort(head);
}

private ListNode sort(ListNode head) {

    if(head == null || head.next == null)
        return head;

    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode head2 = slow.next;
    slow.next = null;
    return merge(sort(head), sort(head2));
}

private ListNode merge(ListNode l1, ListNode l2) {
    if(l1 == null && l2 == null)
        return null;

    if(l1 == null)
        return l2;

    if(l2 == null)
        return l1;


    ListNode helper = new ListNode(0);
    ListNode l3 = helper;
    while(l1 != null && l2 != null) {
        if(l1.val < l2.val) {
            l3.next = l1;
            ListNode temp = l1.next;
            l1.next = null;
            l1 = temp;
        } else {
            l3.next = l2;
            ListNode temp = l2.next;
            l2.next = null;
            l2 = temp;
        }
        l3 = l3.next;
    }

    if(l1 != null)
        l3.next = l1;

    if(l2 != null)
        l3.next = l2;

    return helper.next;
}
