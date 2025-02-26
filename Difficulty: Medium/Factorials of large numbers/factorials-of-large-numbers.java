//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    public static void multiplyNum(ArrayList<Integer> list, int num){
        int carry = 0;
        for(int i = list.size()-1;i!=-1;i--){
            int afterMultiply = list.get(i)*num;
            afterMultiply+=carry;
            list.set(i,afterMultiply%10);
            carry = afterMultiply / 10;
        }
        while(carry!=0){
            list.add(0,carry%10);
            carry = carry / 10;
        }
    }
    public static ArrayList<Integer> factorial(int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 2;i<=n;i++){
            multiplyNum(list,i);
        }
        return list;
    }
}


//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends