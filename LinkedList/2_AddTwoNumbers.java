/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    if(l1 == null && l2 == null)
        return l1;

    if(l1 == null)
        return l2;

    if(l2 == null)
        return l1;

    int carry = 0;
    ListNode helper = new ListNode(0);
    ListNode l3 = helper;
    while(l1 != null && l2 != null) {
        int val = (l1.val + l2.val + carry)%10;
        carry = (l1.val + l2.val + carry)/10;
        ListNode newNode = new ListNode(val);
        l1 = l1.next;
        l2 = l2.next;
        l3.next = newNode;
        l3 = l3.next;
    }

    while(l1 != null) {
        int val = (l1.val + carry)%10;
        carry = (l1.val + carry)/10;
        ListNode newNode = new ListNode(val);
        l1 = l1.next;
        l3.next = newNode;
        l3 = l3.next;
    }

    while(l2 != null) {
        int val = (l2.val + carry)%10;
        carry = (l2.val + carry)/10;
        ListNode newNode = new ListNode(val);
        l2 = l2.next;
        l3.next = newNode;
        l3 = l3.next;
    }

    if(carry > 0) {
        ListNode newNode = new ListNode(carry);
        l3.next = newNode;
    }

    return helper.next;
}
