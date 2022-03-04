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
    public ListNode rotateRight(ListNode head, int k) {
       if(head==null || head.next==null || k==0) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null){
            len++;
            tail = tail.next;
        }
        tail.next = head;
        
        k = len-k%len;
        ListNode curr = head;
        while(k-- > 1){
            curr = curr.next;
        }
        head = curr.next;;
        curr.next = null;
        
        return head;
    }
}