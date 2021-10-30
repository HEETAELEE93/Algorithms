package no7_recursiveTreeGraph;

class SubSet {
	static int n;
	static int[] check;
	public void dfs(int L) {
		if(L == n + 1) {
			String tmp = "";
			for(int i = 1; i <= n; i++) {
				if(check[i] == 1) {
					tmp += i + " ";
					System.out.print(i + " ");
				}
			}
			System.out.println();
			return;
		}
		check[L] = 1; 	// use
		dfs(L+1); 		// left
		check[L] = 0; 	// dont use
		dfs(L+1); 		// right
	}
}

public class N06_SubSet {
	public static void main(String[] args) {
		SubSet sol = new SubSet();
		sol.n = 3;
		sol.check = new int[sol.n+1];
		sol.dfs(1);
	}
}
