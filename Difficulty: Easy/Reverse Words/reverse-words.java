//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int pos1 =0;
        int pos2 = 0;
        while(pos1<= str.length()-1){
            pos2 = str.indexOf('.',pos1);
            if(pos2 == -1) pos2 = str.length();
            String tempString = str.substring(pos1,pos2);
            stack.push(tempString);
            pos1 = pos2+1;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(".");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}