//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T > 0) {
            String[] input = sc.nextLine().trim().split(" ");
            int[] a = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            Solution ob = new Solution();
            ob.segregateElements(a);
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            T--;
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public void segregateElements(int[] arr) {
        // Your code goes here
        Stack<Integer> negative  = new Stack<>();
        Stack<Integer> poisitive = new Stack<>();
        for(int i = arr.length-1;i!=-1;i--){
            if(arr[i]>=0){
                poisitive.add(arr[i]);
            }else{
                negative.add(arr[i]);
            }
        }
        for(int i = 0;i<arr.length;i++){
            if(!poisitive.isEmpty()){
                arr[i] = poisitive.pop();
            }else{
                arr[i] = negative.pop();
            }
        }
    }
}