import heapq
class Solution:
    # Returns shortest distances from src to all other vertices
    def dijkstra(self, V, edges, src):
        # code here
        
        adj_list = [[] for _ in range(V)]
        for s,d,c in edges:
            adj_list[s].append([d,c])
            adj_list[d].append([s,c])
        pq = [(0,src)]
        ans = [float('inf') for _ in range(V)]
        ans[src] = 0
        while pq:
            di, i = heapq.heappop(pq)
            
            for node, dis in adj_list[i]:
                new_dist = dis+di
                if(new_dist<ans[node]):
                    ans[node] = new_dist
                    heapq.heappush(pq,(new_dist,node))
        return ans
            
        
        
        