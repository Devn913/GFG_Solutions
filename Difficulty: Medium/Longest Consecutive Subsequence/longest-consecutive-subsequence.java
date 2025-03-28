//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int max = arr[0];
        for(int num: arr){
            max = Math.max(max,num);
        }
        boolean[] freq = new boolean[max+1];
        for(int num: arr){
            freq[num] = true;
        }
        int maxAns = 0;
        int streak = 0;
        for(int i = 0;i<freq.length;i++){
            if(freq[i]){
                streak++;
                maxAns = Math.max(maxAns,streak);
            }else{
                streak = 0;
            }
        }
        return maxAns;
    }
}