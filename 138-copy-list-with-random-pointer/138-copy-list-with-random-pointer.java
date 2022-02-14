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
       if(head == null){
        return null;
    }
    
    //copy linked list to following structure A -> A' -> B -> B' .... -> C -> C'
    Node p = head;
    while(p != null){
        Node tmp = p.next;
        p.next = new Node(p.val);
        p.next.next = tmp;
        p = tmp;
    }
    
    //copy random list
    p = head;
    while(p != null){
        if(p.random == null){
            p.next.random = null;
        }else{
            p.next.random = p.random.next;
        }
        p = p.next.next;
    }
    
    //split structure A -> A' -> B -> B' => A -> B | A' -> B'
    Node newHead = head.next;
    Node q = newHead;
    p = head;
    
    while(p!= null){
        p.next = p.next.next;
        if(p.next == null){
            q.next = null;
        }else{
            q.next = p.next.next;
        }
        p = p.next;
        q = q.next;
    }
    
    return newHead; 
    }
}