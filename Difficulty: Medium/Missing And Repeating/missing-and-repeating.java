//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] ans = {0,0};
        long sum = 0;
        for(int i =0;i<n;i++){
            int index = Math.abs(arr[i]) - 1;
            sum+=Math.abs(arr[i]);
            if(arr[index]<0){
                ans[0] = index+1;
                sum-=(index+1);
            }else{
                arr[index] = -arr[index];
            }
        }
        long secondSum =(long) (n);
        secondSum = (secondSum+1)*(secondSum)/2;
        ans[1] = (int) (secondSum - sum);
        return ans;
       
        
    }
}