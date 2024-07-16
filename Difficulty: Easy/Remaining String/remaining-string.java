//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    public String printString(String s, char ch, int count) {
        
        int n=s.length();
        int count1=0;
        
        for(int i=0; i<n-1; i++){
           if(ch==s.charAt(i)){
               count1++;
           }   
           
           if(count==count1){
                return s.substring(i+1,s.length());
           }
        }
        
        return "";
    }
}