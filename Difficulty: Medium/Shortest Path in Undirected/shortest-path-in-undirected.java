//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the shortest path from a source node to all other nodes
    class Pair implements Comparable<Pair>{
        int node;
        int distance;
        
        Pair(int node, int distance){
            this.node     = node;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Pair p){
            if(p.distance!=this.distance) return Integer.compare(this.distance, p.distance);
            return Integer.compare(this.node,p.node);
        }
    }
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        int[] ans = new int[adj.size()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = Integer.MAX_VALUE;
        }
        ans[src] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            
            for(int i = 0;i<adj.get(p.node).size();i++){
                if(ans[adj.get(p.node).get(i)]>1+ans[p.node]){
                    ans[adj.get(p.node).get(i)] = 1+ans[p.node];
                    pq.add(
                        new Pair(adj.get(p.node).get(i), 1+ans[p.node])
                        );
                }
                
            }
        }
        for(int i = 0;i<ans.length;i++){
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        return ans;
        
    }
}
