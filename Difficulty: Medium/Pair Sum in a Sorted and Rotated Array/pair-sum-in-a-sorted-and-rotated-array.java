//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.pairInSortedRotated(arr, target));
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {
        // Your code here
        int index     = 1;
        int n         = arr.length;
        int low       = 0;
        int high      = n-1;
        
        while(index!=n){
            if(arr[index-1]>arr[index]){
                low = index;
                high = index-1;
                break;
            }
            index++;
            
        }
        while(low!=high){

            int currentSum = arr[low]+arr[high];
            if(currentSum == target) return true;
            else if(currentSum < target) low = (low+1);
            else high = (high-1);
            
            
            if(low == n) low =0;
            if(high==-1) high =n-1;
        }
        return false;
    }
}
