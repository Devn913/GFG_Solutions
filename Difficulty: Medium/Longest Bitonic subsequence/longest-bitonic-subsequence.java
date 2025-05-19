//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] nums = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.LongestBitonicSequence(n, nums);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int[] iS = new int[n];
        int[] dS = new int[n];
        for(int i = 0;i<n;i++){
            int temp = 1;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    temp = Math.max(temp,1+iS[j]);
                }
            }
            iS[i] = temp;
        }
        
        for(int i = n-1;i>=0;i--){
            int temp = 1;
            for(int j = i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    temp= Math.max(temp,1+dS[j]);
                }
            }
            dS[i] = temp;
        }

        
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(iS[i] ==1 || dS[i]==1) continue;
            ans = Math.max(ans,iS[i] + dS[i] - 1);
        }
        return ans;
    }
}
