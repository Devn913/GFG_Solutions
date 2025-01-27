//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        while(next!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
    public void reorderlist(Node head) {
        if(head == null || head.next == null ) return;
        // use turtle rabbit method, slow-fast pointer to find middle of the linkedlist 
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next; // move once
            fast = fast.next.next; // move twice faster 
        }
        // Divide the linkedList into two parts;
        Node secondHalf = slow.next;
        // Set first half next to null to deattach the flist 
        slow.next = null;
        // reverse the second half
        secondHalf = reverse(secondHalf);
        Node firstHalf  = head;
        Node temp = secondHalf;
        // combinig both list
        while(secondHalf!=null){
            temp = temp.next;
            secondHalf.next = firstHalf.next;
            firstHalf.next  = secondHalf;
            firstHalf = secondHalf.next;
            secondHalf = temp;
        }
        return;


    }

}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            new Solution().reorderlist(head);

            printList(head);
        }
    }
}
// } Driver Code Ends