//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean equals(int[] freq, int[] currFreq){
        for(int i = 0;i<freq.length;i++){
            if(freq[i] !=0 && currFreq[i] == 0 ) return false;
        }
        return true;
    }
    public int findSubString(String s) {
        // Your code goes here
        int[] freq = new int[128];
        for(char c: s.toCharArray()){
            freq[(int) c]++;
        }
        int[] currFreq = new int[128];
        int start = 0;
        int end   = 0;
        currFreq[(int) s.charAt(start)]++;
        int ansSize = s.length();
        while(end<s.length()){
            if(equals(freq,currFreq)){
                ansSize = Math.min(ansSize,end-start+1);
                currFreq[(int) s.charAt(start)]--;
                start++;
            }else if(end<s.length()-1){
                end++;
                currFreq[(int) s.charAt(end)]++;
            }else break;
        }
        return ansSize;
    }
}