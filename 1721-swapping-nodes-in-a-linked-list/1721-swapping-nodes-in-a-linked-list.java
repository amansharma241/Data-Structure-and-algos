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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head;
        int n = k;
        while(--n > 0 && fast != null){ //so that fast is k steps ahead
            fast = fast.next;
        }
        // System.out.println(fast.val);
        ListNode temp = fast; //store the kth node
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //break when fast is at the last node
        int tempValue = temp.val;
        temp.val = slow.val;
        slow.val = tempValue;
  
        return head;
    }
}