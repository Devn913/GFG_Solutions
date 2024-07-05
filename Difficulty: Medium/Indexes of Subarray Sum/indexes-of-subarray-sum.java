//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String s[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for (int ii = 0; ii < res.size(); ii++) ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
         ArrayList<Integer> list = new ArrayList<>();
        // Your code here
        if(s==0){
            for(int i=0;i<n;i++){
                if(arr[i]==0){
                     list.add(i+1);
                     list.add(i+1);
                     return list;
                }
            }
            list.add(-1);
            return list;
        }
        int left = 0;
        int right = 0;
        int currentSum =0;
        while(right!=n || left!=n){
            if(currentSum<s  && right!=n){
                currentSum+=arr[right++];
            }else if(currentSum>s && left!=n){
                currentSum-=arr[left++];
            }else{
                break;
            }
        }
        if(currentSum==s ){
            list.add(left+1);
            if(right==0) right++;
            list.add(right);
        }else{
            list.add(-1);
        }
        return list;
    }
}