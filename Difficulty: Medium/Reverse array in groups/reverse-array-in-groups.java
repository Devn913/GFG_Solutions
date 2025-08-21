class Solution {
    public void reverseInGroups(int[] arr, int k) {
        // code here
        
        for(int i = 0;i<arr.length;i+=k){
            int start = i;
            int end = Math.min(arr.length-1,i+k-1);
            while(start<end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }
}