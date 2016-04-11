/*
Sort a linked list using insertion sort.
*/
public ListNode insertionSortList(ListNode head) {

    if(head == null || head.next == null)
        return head;

    ListNode helper = new ListNode(0);
    helper.next = head;
    ListNode p = head;
    ListNode pre = helper;
    while(p != null) {
        ListNode q = helper;
        while(q.next != p) {
            if(p.val < q.next.val) {
                ListNode temp = p.next;
                p.next = q.next;
                q.next = p;
                p = temp;
                pre.next = temp;
                break;
            } else {
                q = q.next;
            }
        }

        if(q.next == p) {
            pre = p;
            p = p.next;
        }
    }
    return helper.next;
}
