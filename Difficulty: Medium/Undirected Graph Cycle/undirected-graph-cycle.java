//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited, int node, int parent){
        if(visited.contains(node)) return true;
        
        visited.add(node);
        for(int  i = 0;i<adj.get(node).size();i++){
            if(adj.get(node).get(i) == parent) continue; 
            boolean ans = dfs(adj,visited,adj.get(node).get(i),node);
            if(ans) return true;
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            ArrayList<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        
        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < V; i++) {
            if(!visited.contains(i) && dfs(adj,visited,i,-1)) return true;
        }
        return false;
        
    }
}