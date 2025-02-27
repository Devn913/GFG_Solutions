//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        boolean[] freq = new boolean[256];
        int start = 0;
        int end = 0;
        int max = 0;
        while(end<s.length()){
            if(freq[(int) s.charAt(end)]){
                freq[(int) s.charAt(start)] = false;
                start++;
            }
            else{
                freq[(int) s.charAt(end)] = true;
                end++; 
            }
            max = Math.max(max,end-start);
        }
        return max;
    }
}