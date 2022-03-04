// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Stack<Integer> st = new Stack<>();
        Node curr = head;
        while(curr!=null){
            st.push(curr.data);
            curr = curr.next;
        }
        Node res = null;
        int carry = 1;
        while(!st.isEmpty()){
            int sum = 0;
            sum = sum + carry + st.pop();
            Node new_node = new Node(sum%10);
            if(res==null) res = new_node;
            else{
                new_node.next = res;
                res = new_node;
            }
            carry = sum/10;
        }
        if(carry>0){
            Node temp = new Node(carry);
            temp.next = res;
            res = temp;
        }
        return res;
    }
}
