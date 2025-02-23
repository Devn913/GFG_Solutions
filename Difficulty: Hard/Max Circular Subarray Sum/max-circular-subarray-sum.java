//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int kad_max(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0;i<arr.length;i++){
            currSum += arr[i];
            maxSum = Math.max(maxSum,currSum); 
            if(currSum<0) currSum = 0;
        }
        return maxSum;
    }
    public int kad_min(int[] arr){
        int minSum = Integer.MAX_VALUE;
        int currSum = 0;
        for(int i = 0;i<arr.length;i++){
            currSum += arr[i];
            minSum = Math.min(minSum,currSum); 
            if(currSum>0) currSum = 0;
        }
        return minSum;
    }
    public int circularSubarraySum(int arr[]) {
        int totalSum = 0;
        for(int num: arr){
            totalSum+=num;
        }
        int minSum = kad_min(arr);
        int maxSum = kad_max(arr);
        // System.out.println(minSum);
        // System.out.println(maxSum);
        // System.out.println(totalSum);
        return Math.max(totalSum-minSum,maxSum);
        // Your code here
        
    }
}
