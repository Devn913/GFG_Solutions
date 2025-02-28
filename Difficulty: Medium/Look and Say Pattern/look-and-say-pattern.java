//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        
System.out.println("~");
}
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
        if(n == 1) return "1";
        String lastNum = lookandsay(n-1);
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index<lastNum.length()){
            char currElement = lastNum.charAt(index++);
            int freq = 1;
            while(index<lastNum.length()){
                if(lastNum.charAt(index) != currElement) break;
                index++;
                freq++;
            }
            sb.append(Integer.toString(freq));
            sb.append(currElement);
        }
        return sb.toString();
    }
}
