//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    class Pair{
        public int index;
        public int value;
        Pair(int i, int v){
            this.index   = i;
            this.value    = v;
        }
    }
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            list.add(-1);
        }
        Stack<Pair> s = new Stack<>();
        int index = 0;
        while(index!=arr.length){
            if(s.isEmpty()) {
                s.push(new Pair(index,arr[index]));
                index++;
                continue;
            }
            while(!s.isEmpty() && s.peek().value<arr[index]){
                list.set(s.peek().index,arr[index]);
                s.pop();
            }
            s.push(new Pair(index,arr[index]));
            index++;
        }
        return list;
    }
}