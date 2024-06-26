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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1) return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy,nex = dummy,curr = head;
        
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        curr = head;
        while(count>=k){
            curr = pre.next;
            nex = curr.next;
            for(int i=1;i<k;i++){
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            count-=k;
        }
        return dummy.next;
    }
}