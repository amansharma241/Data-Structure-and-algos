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
    public ListNode reverseList(ListNode head) {
        // ListNode dummy = new ListNode(-1);
        ListNode prev = null;
        
        while(head!=null){
            ListNode temp = head.next;
            //temp.next = head;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
        
   

    }
}