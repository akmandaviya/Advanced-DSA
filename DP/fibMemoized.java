package DP;

public class fibMemoized {
	
	//memoization method
	
	private static int fibMemoized(int n, int f[]) {
		//base case
		if(n<=1) {
			return n;
			}
		
		if(f[n] != 0) {
			return f[n];	
    	}
		
		
		int fib1 = fibMemoized(n-1, f);
		int fib2 = fibMemoized(n-2, f);
		int fibN = fib1 + fib2;
		
		f[n] = fibN;
		
		return fibN;

	}
	public static void main(String[] args) {
		int n= 10;
		
		//array size n+1
		//we need fib of 0--> n elements
		//and in 0-->n upto n-1 elements are there so 1 extra
		int arr[] = new int [n+1];
		System.out.println(fibMemoized(n,arr));
	}
}
