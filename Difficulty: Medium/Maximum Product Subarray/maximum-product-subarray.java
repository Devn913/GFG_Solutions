//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] nums) {
        // code here
        int ans = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int N = nums.length;
        
        for(int i = 0;i<N;i++){
            prefix = prefix == 0 ? 1: prefix;
            suffix = suffix == 0 ? 1: suffix;
            
            prefix = prefix*nums[i];
            suffix = suffix*nums[N - i - 1];
            ans = Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }
}