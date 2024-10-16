//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {

        
        // code here
        Node ans1 = head;
        Node ans2 = head.next;
        Node curr = head;
        Node next = head.next;
        boolean chance = true;
        Node[] ans = new Node[2];
       
        ans[0] = ans1;
        ans[1] = ans2;
        if(ans2==null){

            return ans;
        }
        while(true ){
            if(next.next == null){
                curr.next = null;
                break;
            }
            if(curr.next == null){
                next.next = null;
                break;
            }
            
            if(chance){
                curr.next  = next.next;
                curr = curr.next;
                chance = !chance;
            }else{
                next.next = curr.next;
                next = next.next;
                chance = !chance;
            }
            
        }
        return ans;
    }
}
