/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // We will use sizes to understand which list's nodes should be frozen for a while.
    int s1 = size(l1);
    int s2 = size(l2);
    ListNode resHead = null;
    ListNode n = null;
    while (l1 != null || l2 != null) {
        int v1 = 0;
        int v2 = 0;
        if (s1 >= s2) {
            v1 = l1 != null ? l1.val : 0;
            l1 = l1.next;
            s1--;
        }
        // Comparing with s1 + 1 since s1 might be decremented previously
        if (s2 >= s1 + 1) {
            v2 = l2 != null ? l2.val : 0;
            l2 = l2.next;
            s2--;
        }
        // Creating the resulting list in the reversed order.
        n = new ListNode(v1 + v2);
        n.next = resHead;
        resHead = n;
    }
    int carry = 0;
    resHead = null;
    // Now, let's perform the normalization.
    while (n != null) {
        n.val += carry;
        if (n.val >= 10) {
            n.val = n.val % 10;
            carry = 1;
        } else {
            carry = 0;
        }
        ListNode buf = n.next;
        n.next = resHead;
        resHead = n;
        n = buf;
    }
    if (carry > 0) {
        n = new ListNode(1);
        n.next = resHead;
        resHead = n;
    }
    return resHead;
}

private int size(ListNode l) {
    int s = 0;
    while (l != null) {
        l = l.next;
        s++;
    }
    return s;
}
}