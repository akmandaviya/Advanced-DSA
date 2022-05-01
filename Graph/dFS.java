package Graph;

import java.util.ArrayList;

public class dFS {
	
public static void dFS(int node, boolean []isVisited, ArrayList<ArrayList<Integer>>adj, 
		                          ArrayList<Integer> storeDfs) {
	storeDfs.add(node);
	isVisited[node] = true;
	
	for(Integer list: adj.get(node)) {
		if(isVisited[list] == false) {
			dFS(list, isVisited, adj, storeDfs);
		}
	}
}	
public static ArrayList<Integer> graphDfs(int v, ArrayList<ArrayList<Integer>> adj) {
	
	ArrayList<Integer> storeDfs = new ArrayList<>();
	
	boolean isVisted[] = new boolean[v+1];
	
	for(int i=1;i<=v;i++) {
		if(isVisted[i] == false) {
			dFS(i, isVisted, adj, storeDfs);
		}
	}
	return storeDfs;
}

public static void displayAns(ArrayList<Integer> ans) {
	for(int i=0;i<ans.size();i++) {
		System.out.print(ans.get(i) + " ");
	}
}
public static void main(String[] args) {
	
	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	for(int i=0;i< 6; i++) {
		adj.add(new ArrayList<>());
	}
	
	adj.get(1).add(2);
    adj.get(1).add(3);
    adj.get(1).add(4);
    adj.get(1).add(5);
    adj.get(2).add(4);
    adj.get(2).add(1);
    adj.get(3).add(1);
    adj.get(4).add(1);
    adj.get(4).add(2);
    adj.get(5).add(1);
    
    ArrayList<Integer>ans = graphDfs(5, adj);
    displayAns(ans);
	
}
}
