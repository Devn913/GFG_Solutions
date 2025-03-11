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
        int ans = Integer.MIN_VALUE;
        int N = nums.length;
        int prefix = 1;
        int suffix = 1;

        for(int i = 0;i<N;i++){
            prefix = prefix * nums[i];
            suffix = suffix * nums[N - i -1];
            ans = Math.max(ans,Math.max(suffix,prefix));
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1; 
        }
        return ans;
    }
}