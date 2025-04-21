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
    
    // Approach 1: Memoization - helper(height,memo,n-1);
    // TC: O(2^n)
    // SC: O(1)
    // int helper(int[] height, int[] memo, int ind){
    //     if(ind==0) return 0;
    //     if(ind == 1) return Math.abs(height[0] - height[1]);
    //     if(memo[ind]!=-1) return memo[ind];
    //     memo[ind] = Math.min(
    //         Math.abs(height[ind] - height[ind-1]) + helper(height,memo,ind-1),
    //         Math.abs(height[ind] - height[ind-2]) + helper(height,memo,ind-2)
    //         );
    //     return memo[ind];
    // }
    
    
    // Approach 2: Dynammic Programming 
    // TC: O(n)
    // SC: O(n)
    // int minCost(int[] height) {
    //     if(height.length < 2) return 0;
    //     dp[1] = Math.abs(height[0] - height[1]);
    //     for(int i = 2;i<height.length;i++){
    //         dp[i] = Math.min(
    //             Math.abs(height[i] - height[i-1]) + dp[i-1],
    //             Math.abs(height[i] - height[i-2]) + dp[i-2]
    //             );
    //     }
    //     return dp[height.length-1];
    // }
    
    // Approach 3: Optimized 
    // TC: O(n)
    // SC: O(1)
    // int minCost(int[] height) {
    //     if(height.length < 2) return 0;
    //     int secondPrev = 0;
    //     int prev = Math.abs(height[0] - height[1]);
    //     int ans = 0;
    //     for(int i = 2;i<height.length;i++){
    //         ans = Math.min(
    //             Math.abs(height[i] - height[i-1]) + prev,
    //             Math.abs(height[i] - height[i-2]) + secondPrev
    //             );
    //         secondPrev = prev;
    //         prev = ans;
         
    //     }
    //     return ans;
    // }
    
    
    
    int helper(int[] height,int[] memo, int index){
        if(index>=height.length-1) return 0;
        if(index==height.length-2) return Math.abs(height[index]-height[index+1]);
        if(memo[index]!=-1) return memo[index];
        int choice1 = helper(height,memo,index+1);
        int choice2 = helper(height,memo,index+2);
        
        int ans1    = Math.abs(height[index]-height[index+1]) + choice1;
        int ans2    = Math.abs(height[index]-height[index+2]) + choice2;
        
        memo[index] = Math.min(ans1,ans2);
        return memo[index];
    }
    
    int minCost(int[] height) {
        int[] memo =  new int[height.length];
        for(int i = 0;i<memo.length;i++){
            memo[i] = -1;
        }
        return helper(height,memo,0);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


//{ Driver Code Starts.

// } Driver Code Ends