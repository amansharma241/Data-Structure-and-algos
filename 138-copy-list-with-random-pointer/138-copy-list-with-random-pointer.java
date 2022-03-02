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
      if(head==null) return null;
        Node curr = head;
        
        //form links
        while(curr!=null){
            Node temp = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = temp;
            curr = temp;
        }
        // assign random pointers
         curr = head;
        while(curr!=null){
            if(curr.random!=null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        
        // break links
        curr = head;
       Node fake = head.next;
        Node ans = fake;
        while(curr!=null && fake!=null){
            curr.next = curr.next.next;
            if(curr.next!=null){ // this line is necessary because it helps us in handling if we have a single node
                fake.next = fake.next.next;
            }
            curr = curr.next;
            fake = fake.next;
        }
        return ans;
    }
}