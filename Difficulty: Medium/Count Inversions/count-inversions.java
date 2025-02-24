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
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    int ans = 0;
    void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        
        int index = 0;
        int leftIndex = left;
        int rightIndex = mid+1;
        while(index<temp.length){
            if(leftIndex == mid+1){
                temp[index++] = arr[rightIndex++];
                continue;
            }else if(rightIndex == right+1){
                temp[index++] = arr[leftIndex++];
                continue;
            }
            
            if(arr[leftIndex]>arr[rightIndex]){
                ans+=(mid+1-leftIndex);
                temp[index++] = arr[rightIndex++];
            }else{
                temp[index++] = arr[leftIndex++];
            }
        }
        index = 0;
        for(int i = left;i<=right;i++){
            arr[i] = temp[index++];
        }
        
    }
    void mergeSort(int[] arr, int left, int right){
        if(left == right) return;
        int mid = (left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr, left,mid,right);
        return;
    }
    int inversionCount(int arr[]) {
        // Your Code Here
        mergeSort(arr,0,arr.length-1);
        return ans;
        
    }
}