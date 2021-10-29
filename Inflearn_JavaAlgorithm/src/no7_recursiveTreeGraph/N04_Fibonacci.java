package no7_recursiveTreeGraph;

class Fibonacci {
	static int[] fibo;
	public int dfs(int n) {
		if(fibo[n] != 0) {
			return fibo[n];
		}
		if (n == 1) {
			return fibo[n] = 1;
		} else if (n == 2) {
			return fibo[n] = 1;
		} 
		
		return fibo[n] = dfs(n - 2) + dfs(n - 1);
	}
}

public class N04_Fibonacci {
	public static void main(String[] args) {
		int n = 45;
		Fibonacci sol = new Fibonacci();
		long beforeTime = System.currentTimeMillis();
		
		sol.fibo = new int[n+1];
		sol.dfs(n);
		for(int i = 1; i < n; i++) {
			System.out.println(sol.fibo[i]);
		}
		System.out.println();
		
		long afterTime = System.currentTimeMillis(); 
		System.out.println("시간차이(ms) : "+ (afterTime - beforeTime));
	}
}
