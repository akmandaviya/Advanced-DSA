package DP;

public class countPaths {
	
//memoization method
	
private static int cPMemoized(int n , int f[]) {
	//base cases
	if(n == 0) {
		return 1;
	}
	if(n < 0) {
		return 0;
	}
	
	if(f[n] != 0) {
		return f[n];
	}
	// faith
	int a1 = cPMemoized(n-1, f);
	int a2 = cPMemoized(n-2, f);
	int a3 = cPMemoized(n-3, f);
	
	// expectations 
	int cP = a1+a2+a3;
	
	f[n] = cP;
	return cP;
}

//tabulation method

//done by iteration

//steps for tabulation
//1) storage and meaning
//2) direction of problems
//3) travel and solve

//in our case
//1) array for storage and for ex : how many ways are there for 4-->0
//2) 0-->0 or 6-->0 which is bigger, obviously 0-->0 small do we move from left to right
//3) traverse

private static int cPTable(int n) {
	int [] f = new int[n+1];
	
	f[0] = 1;
	
	for(int i=1;i<=n; i++) {
		if(i == 1) {
			f[i] = f[i-1];
		}
		else if(i == 2) {
			f[i] = f[i-1] + f[i-2];
		}
		else {
			f[i] = f[i-1] + f[i-2] + f[i-3];
		}
	}
	return f[n];
}

public static void main(String[] args) {
	int n = 5;
	int arr[] = new int[n+1];
	System.out.println(cPMemoized(n, arr));
	System.out.println(cPTable(n));
}
}
