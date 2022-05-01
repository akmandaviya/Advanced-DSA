package Graph;

import java.util.ArrayList;

public class adjList {

public static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest) {
	adj.get(source).add(dest);
	adj.get(dest).add(source);
}	
public static void main(String[] args) {
	int n=3,m=3;
	
	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	//adding the list
	for(int i=0;i<=n;i++) {
		adj.add(new ArrayList<Integer>());
	}

//	adj.get(u).add(v);
//	adj.get(v).add(u);
	
	//egde 1&2
	adj.get(1).add(2);
	adj.get(2).add(1);
	
	//edge 2&3
	adj.get(3).add(2);
	adj.get(2).add(3);
	
	//edge 1&3
	adj.get(3).add(1);
	adj.get(1).add(3);
	
	
	for(int i=1;i<n;i++) {
		for(int j=0;j<adj.get(i).size();j++) {
			System.out.print(adj.get(i).get(j) + " ");
		}
		System.out.println();
			
	}
}
}
