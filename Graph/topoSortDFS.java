package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class topoSortDFS {
	
	public static void findTopo(int node, int isVisited[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
		isVisited[node] = 1;
		
		for(Integer list: adj.get(node)) {
			if(isVisited[list] == 0) {
				findTopo(list, isVisited, adj, st);
			}
		}
		st.push(node);
	}
	
	public static int[] topoSort(int n, ArrayList<ArrayList<Integer>>adj) {
		Stack<Integer>st = new Stack<>();
		int isVisited[] = new int[n];
		
		for(int i=0;i<n;i++) {
			if(isVisited[i] == 0)  {
				findTopo(i, isVisited, adj, st);
			}
		}
		
		int topo[] = new int[n];
		int end = 0;
		
		while(!st.isEmpty()) {
			topo[end++] = st.pop();
		}
		
		return topo;
		
	
	}
	
public static void main(String[] args) {
	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	int n=6;
	
	for(int i=0;i<n;i++) {
		ArrayList<Integer> list = new ArrayList<>();
		adj.add(list);
	}
	
	adj.get(5).add(0);
	adj.get(5).add(2);
	
	adj.get(2).add(3);
	adj.get(3).add(1);
	
	adj.get(4).add(1);
	adj.get(4).add(0);
	
	int res[] = topoSort(n, adj);
	System.out.println("Topo sort is:");
	for(int i=0;i<res.length;i++) {
		System.out.print(res[i] + "");
	}
}
}
