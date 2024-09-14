//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for(int i = 0;i<arr.size();i++){
            if(arr.get(i)<0){
                neg.add(arr.get(i));
                continue;
            }
            pos.add(arr.get(i));;
        }
        for(int i = 0;i<arr.size();i++){
            if(pos.size()==0){
                arr.set(i,neg.poll());
                continue;
            }
            if(neg.size()==0){
                arr.set(i,pos.poll());
                continue;
            }
            int element = pos.peek();
            if(i%2!=0){
                element = neg.poll();
            }else pos.poll();
            arr.set(i,element);
        }

    }
}