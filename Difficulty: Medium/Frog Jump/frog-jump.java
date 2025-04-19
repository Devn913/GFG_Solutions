//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    int helper(int[] height, int[] memo, int curr){
        if(curr >= height.length) return Integer.MAX_VALUE;
        if(curr ==  height.length -1) return 0;
        if(memo[curr]!=-1) return memo[curr];
        int jump1 = Integer.MAX_VALUE,jump2 = Integer.MAX_VALUE;
        
        int ans1 = helper(height,memo,curr+1);
        int ans2 = helper(height,memo,curr+2);
        
        if(curr+1<height.length){
            jump1 = Math.abs(height[curr]-height[curr+1]);
            if(ans1!=Integer.MAX_VALUE){
                ans1+=jump1;
            }
        }
        if(curr+2<height.length){
            jump2 = Math.abs(height[curr] - height[curr+2]);
            if(ans2!=Integer.MAX_VALUE){
                ans2+=jump2;
            }
        }
        memo[curr] = Math.min(ans1,ans2);
        return memo[curr];
        
    }
    int minCost(int[] height) {
        int[] memo = new int[height.length];
        for(int i = 0;i<memo.length;i++){
            memo[i] = -1;
            
        }
        // code here
        return helper(height,memo,0);
    }
}


//{ Driver Code Starts.

// } Driver Code Ends