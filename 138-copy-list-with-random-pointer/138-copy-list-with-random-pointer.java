/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;
        Node dummy = new Node(-1);
        Node nhead = dummy;
        
        while(curr!=null){
            nhead.next = new Node(curr.val);
            map.put(curr,nhead.next);
            nhead = nhead.next;
            curr = curr.next;
        }
        nhead = dummy.next;
        curr = head;
        
        while(nhead!=null){
            nhead.random = (curr.random!=null ? map.get(curr.random):null);
            nhead = nhead.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}