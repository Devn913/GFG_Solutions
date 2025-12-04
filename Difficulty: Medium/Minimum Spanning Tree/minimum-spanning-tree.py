import heapq
class Solution:
    def spanningTree(self, V, edges):
        # code here
        pq = [(0,0)] # (w,n,p)
        vis = [False]*V
        ans = 0
        
        adj_list = [[] for _ in range(V)]
        for u,v,w in edges:
            adj_list[u].append((v,w))
            adj_list[v].append((u,w))
        
        while(pq):
            w,n = heapq.heappop(pq)
            
            if(vis[n]==True): 
                continue
            vis[n] = True
            ans+=w
            for c,w in adj_list[n]:
                if(not vis[c]):
                    heapq.heappush(pq, (w, c))
        return ans    