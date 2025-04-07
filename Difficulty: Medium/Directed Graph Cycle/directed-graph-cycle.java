//{ Driver Code Starts
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
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited, HashSet<Integer> currentChain, int node){
        if(currentChain.contains(node)) return true;
        if(visited.contains(node)) return false;
        
        visited.add(node);
        currentChain.add(node);
        for(int i= 0;i<adj.get(node).size();i++){

            boolean ans = dfs(adj,visited,currentChain,adj.get(node).get(i));

            if(ans) return true;
        }
        currentChain.remove(node);
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            ArrayList<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        
        for(int i =0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cc      = new HashSet<>();
        
        for(int i = 0;i<V;i++){
            
            if(!visited.contains(i) && dfs(adj,visited,cc,i)) return true;
        }
        return false;
    }
}