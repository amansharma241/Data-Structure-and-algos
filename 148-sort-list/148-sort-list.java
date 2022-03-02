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
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        int[] arr = new int[count];
        int index = 0;
        temp = head;
        while(temp != null){
            arr[index++] = temp.val;
            temp = temp.next;
        }

        Arrays.sort(arr);

        ListNode result = new ListNode(0);
        ListNode a = result;

        for(int i = 0;i<arr.length;i++) {
            ListNode b = new ListNode(arr[i]);
            a.next = b;
            a = a.next;
        }

        return result.next; 
    }
}