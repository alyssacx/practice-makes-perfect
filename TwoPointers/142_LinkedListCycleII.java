/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/
public ListNode detectCycle(ListNode head) {
    if(head == null)
        return null;

    ListNode fast = head;
    ListNode slow = head;
    boolean hasCycle = false;
    while(fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) {
            hasCycle = true;
            break;
        }
    }
    if(!hasCycle) {
        return null;
    }

    fast = head;
    while(slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
