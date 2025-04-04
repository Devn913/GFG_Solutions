//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    static void printSorted(ArrayList<Integer> list)
    {
        for(Integer x : list)
        System.out.print(x + " ");
    }
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0)
		{
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int c = sc.nextInt();
		    
		    int A[] = new int[a];
		    int B[] = new int[b];
		    int C[] = new int[c];
		    
		    for(int i = 0; i < a; i++)
		      A[i] = sc.nextInt();
		      
		    for(int i = 0; i < b; i++)
		      B[i] = sc.nextInt();
		      
		    for(int i = 0; i < c; i++)
		      C[i] = sc.nextInt();
		    
		    printSorted(new Solution().merge3sorted(A, B, C));
		    System.out.println();
		    
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // A[], B[], C[]: input arrays
    //Function to merge three sorted lists into a single list.
    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
        // add ypur code here
        int i = 0;
        int j = 0;
        int k = 0;
        int index = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int size = A.length + B.length + C.length;
        while(index<size){
            int firstNum  = (i < A.length ? A[i] :  Integer.MAX_VALUE);
            int secondNum = (j < B.length ? B[j] :  Integer.MAX_VALUE);
            int thirdNum  = (k < C.length ? C[k] :  Integer.MAX_VALUE);
            
            if(firstNum<=secondNum && firstNum<=thirdNum){
                result.add(firstNum);
                i++;
            }else if(secondNum<=firstNum && secondNum<=thirdNum){
                 result.add(secondNum);
                 j++;
            }else{
                result.add(thirdNum);
                k++;
            }
            index++;
        }
        return result;
    }
}
