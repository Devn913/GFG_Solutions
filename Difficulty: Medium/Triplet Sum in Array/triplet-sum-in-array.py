class Solution:
    def hasTripletSum(self, arr, target):
        # Code Here
        arr.sort()
        for i in range(len(arr)):
            low = i+1
            high = len(arr)-1
            while(low<high):
                if(arr[low]+arr[high]+arr[i] == target):
                    return True
                elif(arr[low]+arr[high]+arr[i] > target):
                    high-=1
                else:
                    low+=1
        return False