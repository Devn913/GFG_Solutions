//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int majority1 = 0;
        int majority2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int num: nums){
            if(num == majority1){
                count1++;
            }else if(num==majority2){
                count2++;
            }else if(count1 == 0){
                majority1 = num;
                count1++;
            }else if(count2 == 0 ){
                majority2 = num;
                count2++;
            }else{
                count1 --;
                count2 --;
            }
        }
        if(majority1>majority2){
            int temp = majority2;
            majority2 = majority1;
            majority1 = temp;
        }
        count1 = 0;
        count2 = 0;
        for(int num: nums){
            if(num == majority1){
                count1++;
            }else if(num == majority2){
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        if (count1 > n / 3) {
            res.add(majority1);
        }
        if (count2 > n / 3) {
            res.add(majority2);
        }
        

        return res;        
        
    }
}
