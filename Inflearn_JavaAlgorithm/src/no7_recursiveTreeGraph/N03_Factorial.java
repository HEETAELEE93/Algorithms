package no7_recursiveTreeGraph;

class Factorial {
	public int dfs(int n) {
		if(n == 1) {
			return 1;
		}
		return n * dfs(n-1);
	}
}
public class N03_Factorial {
	public static void main(String[] args) {
		int n = 6;
		Factorial sol = new Factorial();
		System.out.println(sol.dfs(n));
	}
}
