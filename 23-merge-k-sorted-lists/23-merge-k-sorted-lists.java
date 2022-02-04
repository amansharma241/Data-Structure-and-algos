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
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
           return a.val-b.val;
       });
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        for(ListNode l: lists){
            if(l!=null) pq.add(l);
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.remove();
            prev.next = temp;
            temp = temp.next;
            prev = prev.next;
            
            if(temp!=null) pq.add(temp);
        }
        return dummy.next;
    }
}