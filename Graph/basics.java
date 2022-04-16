package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class basics {
	

	
//BFS using adjacency List
	
private static	ArrayList getAdjList() {
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	
	ArrayList<Integer> list1 = new ArrayList<>();
	list1.add(1);
	list1.add(2);
	list1.add(3);
	adjList.add(list1);
	
	ArrayList<Integer> list2 = new ArrayList<>();
	adjList.add(list2);
	
	ArrayList<Integer> list3 = new ArrayList<>();
	list3.add(1);
	adjList.add(list3);
	
	ArrayList<Integer> list4 = new ArrayList<>();
	list4.add(2);
	list4.add(4);
	adjList.add(list4);
	
	ArrayList<Integer> list5 = new ArrayList<>();
    adjList.add(list5); 
    
    return adjList;
}


private static void performBFS(ArrayList<ArrayList<Integer>>adjList) {
	Queue<Integer> q = new LinkedList<>();
	q.add(0); //index 0 or vertex
	
	
	//for checking previous visited or not
	//boolean array
	
	//by default boolean false, while we adding to queue if false.
	//when we remove we mark visited true as we print it
	
	boolean[] isVisited = new boolean[adjList.size()]; 
	
	
	while(!q.isEmpty()) {
		Integer vertex = q.remove();//poping from queue
		 
		System.out.print(vertex + " ");
		isVisited[vertex] = true; ///true when we are printing it
		
		
		//checking if there are reachable node or not
		ArrayList<Integer> newVertexReachable = adjList.get(vertex);
		
		if(!newVertexReachable.isEmpty()) {
			for(Integer newVertex : newVertexReachable) {
				if(!isVisited[newVertex]) {
					q.add(newVertex);
				}
				
			}
		}
	}
	
} 

//BFS using matrix 
private static void performBFS(Integer[][] matrix) {
	Queue<Integer> q = new LinkedList<>();
	q.add(4); //index 0 or vertex

	boolean[] isVisited = new boolean[matrix.length]; 
	
	
	while(!q.isEmpty()) {
		Integer vertex = q.remove();//poping from queue
		 
		System.out.print(vertex + " ");
		isVisited[vertex] = true; ///true when we are printing it
		
		
		//checking if there are reachable node or not
         ArrayList<Integer> vertices = 	getReachableVertices(matrix, vertex);	
         
         
		
			for(Integer newVertex : vertices) {
				if(!isVisited[newVertex]) {
					q.add(newVertex);
				}
			}
		}		
}

private static ArrayList<Integer> getReachableVertices(Integer[][]matrix, Integer vertex) { 
	ArrayList<Integer> vertices = new ArrayList<>();
	
	for(int i=0;i<matrix.length;i++) {
	if(matrix[i][vertex] == 1) { //row and coloumn
		vertices.add(1);
	  }	
	}
	return vertices;
}

public static void main(String[] args) {
	ArrayList<ArrayList<Integer>> adjList = getAdjList();
	
	//performBFS(adjList);
	
	Integer [][] matrix ={   {0,0,0,0,0},
			                 {1,0,1,0,0},
			                 {1,0,0,1,0},
			                 {1,0,0,0,0},
			                 {0,0,0,1,0}  };
	
	//performBFS(matrix);
	
	
	}
}

