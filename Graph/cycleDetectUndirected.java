package Graph;

import java.util.ArrayList;
import java.util.Arrays;


//Approach: Run a for loop from the first node to the last node and check if the node is visited. 
//If it is not visited then call the function recursively which goes into the depth as known as DFS search and
//if you find a cycle you can say that there is a cycle in the graph.


public class cycleDetectUndirected { //by DFS
      ///dfs traversal only
	public boolean checkForCycle(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>>adj) {
		
		vis[node] = true;
		for(Integer it: adj.get(node)) {
			
			if(vis[it] == false) { //here it means this node not visited.. so visit it by dfs
				if(checkForCycle(it, node, vis, adj) == true) { //cycle found
					return true;
				}
				else if (it != parent) { //visited node is not parent
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isCycle(int v, ArrayList<ArrayList<Integer>>adj) {
		//0 based indexing graph
		boolean vis[] = new boolean [v];
	  
		for(int i=0;i<v;i++) {
			if(vis[i] == false) {
				if(checkForCycle(i, -1, vis, adj)) {
					return true;
				}
			}

		}
		return false;
	} 
	
	public static void main(String[] args) {


        int V = 5;

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList < > ());
        }
        // edge 0---1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // adge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // adge 3--4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // adge 1--4
        adj.get(1).add(4);
        adj.get(4).add(1);


        cycleDetectUndirected obj = new cycleDetectUndirected();
        boolean ans = obj.isCycle(V, adj);
        if (ans == true) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");

        }
    }
}
