//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            List<Integer> brr = new ArrayList<>();
            List<Integer> crr = new ArrayList<>();

            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }

            String input2 = sc.nextLine();
            Scanner ss2 = new Scanner(input2);
            while (ss2.hasNextInt()) {
                brr.add(ss2.nextInt());
            }

            String input3 = sc.nextLine();
            Scanner ss3 = new Scanner(input3);
            while (ss3.hasNextInt()) {
                crr.add(ss3.nextInt());
            }

            Solution ob = new Solution();
            List<Integer> res = ob.commonElements(arr, brr, crr);

            if (res.size() == 0) System.out.print(-1);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> commonInTwoSortedArray(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while(index1<list1.size() && index2 < list2.size()){
            if(list1.get(index1) < list2.get(index2)){
                index1++;
            } else if(list1.get(index1)>list2.get(index2)){
                index2++;
            } else{
                int num = list1.get(index1);
                result.add(num);
                
                while(index1 < list1.size() && list1.get(index1) == num){
                    index1++;
                }
                
                while(index2 < list2.size() && list2.get(index2) == num){
                    index2++;
                    
                }
            }
        }
        return result;
    }
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,List<Integer> arr3){

        // Code Here
        // System.out.println(tmp.toString());
        return commonInTwoSortedArray(arr3,commonInTwoSortedArray(arr1,arr2));
    }
}