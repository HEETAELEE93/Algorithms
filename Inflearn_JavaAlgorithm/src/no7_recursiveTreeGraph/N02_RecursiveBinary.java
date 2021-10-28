package no7_recursiveTreeGraph;

class RecursiveBinary{
	public void dfs(int n) {
		if(n < 1) {
			return;
		}
		dfs(n/2);
		if(n % 2 == 1) {
			System.out.print(1);
		} else {
			System.out.print(0);
		}
	}
	public void dfs2(int n) {
		if(n == 0) {
			return;
		}
		dfs(n/2);
		System.out.print(n%2);
	}
}

public class N02_RecursiveBinary {
	public static void main(String[] args) {
		int n = 100;
		RecursiveBinary sol = new RecursiveBinary();
		sol.dfs(n);
		System.out.println();
		sol.dfs2(n);
	}
}
