package Graph;

import java.util.ArrayList;



                                       //by using DFS
public class cycleDetectDirect {
	
	//dfs function

	  private static boolean checkCycle(int node,  ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
		//when function called, mark both as 1  
		  vis[node] = 1;
	        dfsVis[node] = 1;
	        //after that checking for adjacent nodes
	        for(Integer neighbor: adj.get(node)) {
	        	if(vis[neighbor] == 0) { //means is not visited
	                if(checkCycle(neighbor, adj, vis, dfsVis) == true) {//then call recursive call to dfs
	                	return true; // if this true then graph has cycle
	            	}
	        	} else if(dfsVis[neighbor] == 1) {
	            	return true;
	        	}
	        }
	        dfsVis[node] = 0;
	        return false;   //  no cycle detected
	    }
	
	  
		//function to check if cycle or not ?
  
	  public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
	        int vis[] = new int[N];
	        int dfsVis[] = new int[N];
	       
	        for(int i = 0;i<N;i++) {
	        	if(vis[i] == 0) {
	                if(checkCycle(i, adj, vis, dfsVis) == true) return true;
	        	}
	        }
	        return false;
	    }
	
public static void main(String[] args) {
	
	int v = 6;
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>(v);
	
	//vertex 0
	ArrayList<Integer> list = new ArrayList<>();
	list.add(1); // out degree
	graph.add(list);
	
	
	//vertex 1
	list  = new ArrayList<Integer>();
	list.add(2);
	list.add(5);
	graph.add(list);
	
	//vertex 2
	list = new ArrayList<Integer>();
	list.add(3);
	graph.add(list);
	
	//vertex 3
	list = new ArrayList<Integer>();
	list.add(4);
	graph.add(list);
	
	//vertex 4
	list = new ArrayList<Integer>();
	list.add(0);
	list.add(1);
	graph.add(list);
	
	//vertex 5
	list = new ArrayList<Integer>();
	graph.add(list);
	
	
    //now checking our condition
	
	if(isCyclic(v, graph)) {
		System.out.println("Cycle Detected");
	}else {
		System.out.println( "No cylce Detected");
	}
}
}
