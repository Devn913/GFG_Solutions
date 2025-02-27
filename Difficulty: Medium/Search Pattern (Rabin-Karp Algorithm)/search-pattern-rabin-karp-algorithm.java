//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{

    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        // Rabin-Karp Algo
        
        int MOD                = 1000000000 + 7;
        int P                  = 998857;
        int N                  = text.length();
        int M                  = pattern.length();
        long d                 = 1;
        long targetHashValue   = 0;
        long rollingHashValue  = 0;
        for(int i = 0;i<M;i++){
            targetHashValue  = (targetHashValue  * P + (int) pattern.charAt(i)) % MOD;
            rollingHashValue = (rollingHashValue * P + (int) text.charAt(i)) % MOD;
            d = (d * P) % MOD;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i+M <= N;i++){
            if(targetHashValue == rollingHashValue){
                list.add(i+1);
            }
            if(i+M<N){
                rollingHashValue = (rollingHashValue * P + text.charAt(i+M) - d*text.charAt(i)) % MOD;
                if(rollingHashValue<0){
                    rollingHashValue+=MOD;
                }
            }
        }
        return list;
    }
}