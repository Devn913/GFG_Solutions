//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        long ans = 0;
        int[] rem = new int[k];
        for(int i = 0;i<n;i++){
            rem[arr[i]%k]++;
        }
        
        for(int i = 0;i+i<k;i++){
            if(i == 0) ans = ans + (rem[0]*(rem[0]-1)/2);
            else ans = ans+ (rem[i]*rem[k-i]);
        }
        if(k%2 == 0){
            ans = ans + (rem[k/2]*(rem[k/2]-1)/2);
        }

        return ans;
        
    }
}