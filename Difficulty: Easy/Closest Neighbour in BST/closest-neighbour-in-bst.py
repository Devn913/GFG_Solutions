'''
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
    def findMaxFork(self, root, k):
        #code here
        result = -1
        while(root):
            if(root.data>k):
                root = root.left
            else:
                result = root.data
                root = root.right
        return result
                