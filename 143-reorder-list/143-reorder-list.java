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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
       ListNode dummy = new ListNode(-1);
       dummy.next = head;
        ListNode curr = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        } 
        // if(fast!=null){
        //     slow = slow.next;
        // }
       prev.next = null;
        ListNode tail = reverse(slow);
        
        while(head!=null && tail!=null){
            ListNode temp1 = head.next;
            ListNode temp2 = tail.next;
            head.next = tail;
           if(temp1!=null)  tail.next = temp1;
            head = temp1;
            tail = temp2;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode dummy = head;
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}