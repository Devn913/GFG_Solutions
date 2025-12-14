from collections import deque
class Solution:
    def topoSort(self, V, edges):
        # Code here
        
        indegree = [0]*V
        adj = [[] for _ in range(V)]
        for u,v in edges:
            adj[u].append(v)
            indegree[v]+=1
            
        q = deque([])
        
        for i in range(V):
            if(indegree[i] == 0):
                q.append(i)
        ans = []
        
        while(q):
            
            node = q.popleft()
            
            ans.append(node)
            
            for nei in adj[node]:
                if(indegree[nei] == 0): continue
                indegree[nei]-=1
                if(indegree[nei] == 0): q.append(nei)
        return ans
                
                    
        
        
        
        