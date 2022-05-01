package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class bFS {
public static ArrayList<Integer> graphBfs(int v, ArrayList<ArrayList<Integer>>adj){
	
	ArrayList<Integer> bfs = new ArrayList<>();
	
	//visited array
	boolean isVisited []= new boolean[v+1];
	
    for(int i=1; i<=v; i++)	 {
    	if(isVisited[i] == false) {
    		
    		Queue<Integer> q = new LinkedList<>();
    		q.add(i);
    		isVisited[i] = true;
    		
    		while(!q.isEmpty()) {
    			Integer node = q.poll();//deleting the front element from the q.
    			bfs.add(node);
    			
    			
    			for(Integer list: adj.get(node)) {
    				if(isVisited[list] == false) {
    					isVisited[list] =true;
    					q.add(list);
    				}
    			}
    		}
    	}
     }
	return bfs;
}

public static void displayAns(ArrayList<Integer> ans) {
	for(int i=0; i<ans.size(); i++) {
		System.out.println(ans.get(i) + " ");
	}
}



public static void main(String[] args) {
		
	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	for(int i=0; i <= 6; i++) {
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
    
	ArrayList<Integer> ans =  graphBfs(5, adj);
	displayAns(ans);
	
}
}
