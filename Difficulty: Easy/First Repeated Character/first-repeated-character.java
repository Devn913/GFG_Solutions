//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java



// Solution 1:
class Solution 
{ 
    String firstRepChar(String s) 
    { 
        // code here\
        boolean[] freq = new boolean[26];
        for(char c: s.toCharArray()){
            int index = c - 'a';
            if(freq[index] == true) return Character.toString(c);
            freq[index] = !freq[index];
        }
        return Integer.toString(-1);
    }
} 