#User function Template for python3

class Solution:
    def segregate0and1(self, arr):
        # code here
        left = []
        right = []
        for i in range(len(arr)):
            if(arr[i] == 0):
                left.append(arr[i])
            else:
                right.append(arr[i])
        
        index = 0
        
        
        
        for i in range(len(left)):
            arr[index] = left[i]
            index+=1
            
        for i in range(len(right)):
            arr[index] = right[i]
            index+=1
            
        return arr
        