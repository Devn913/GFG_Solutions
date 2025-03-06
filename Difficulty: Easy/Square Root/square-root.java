//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        // Your code here
        int low = 0;
        int high = n;
        int ans = low + (high - low)/2;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            if(1l *mid*mid > n){
                high = mid-1;
            }else{
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
}
