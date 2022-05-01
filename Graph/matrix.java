package Graph;


public class matrix {
	
public static void addEdge(int source, int dest) {
}	
public static void main(String[] args) {
	
	int n =3,m=3;
	
	int adjMat[][] = new int[n+1][n+1];
	
	//adding edges
	//edge 1&2
	adjMat[1][2] = 1;
	adjMat[2][1] = 1;
	//edge 2&3
	adjMat[2][3] = 1;
	adjMat[3][2] = 1;
	//edge1&3
	adjMat[1][3] = 1;
	adjMat[3][1] = 1;
	
	for (int i = 0; i <=n; i++) { 
		for (int j = 0; j <=n; j++) { 
			   System.out.print(adjMat [i][j]+" "); 
		} 
		       System.out.println();  
		}
}
}
