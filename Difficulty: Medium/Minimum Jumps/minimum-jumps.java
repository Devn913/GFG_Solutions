//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // code here
        if(arr.length == 1) return 0;
        int totalJump = 0;
        int index = 0;
        while(index<=arr.length){
            if(arr[index] == 0) return -1;
            int maxRange = index + arr[index];
            totalJump++;
            if(maxRange>=arr.length-1) return totalJump;
            int maxJumpIndex = index+1;
            for(int i = index+1;i<=maxRange;i++){
                if(i+arr[i]>=maxJumpIndex + arr[maxJumpIndex]) maxJumpIndex = i;
            }
            index = maxJumpIndex;
        }
        return totalJump;
    }
}