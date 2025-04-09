//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    
    public static void toplogicalOrder(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] visited, int node){
        if(visited[node]) return;
        visited[node] = true;
        
        for(int i = 0;i<adj.get(node).size();i++){
            if(!visited[adj.get(node).get(i)]) toplogicalOrder(adj,st,visited,adj.get(node).get(i));
            
        }
        st.push(node);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i<V;i++){
            ArrayList<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        
        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        boolean[] visited = new boolean[V];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i =0;i<V;i++){
            if(!visited[i]) toplogicalOrder(adj,st,visited,i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
        
    }
}