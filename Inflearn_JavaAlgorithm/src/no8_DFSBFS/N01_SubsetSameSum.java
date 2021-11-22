package no8_DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SubsetSameSum {
	String answer = "NO";
	int n;
	int total;
	boolean flag = false;

	public String solution_dfs(int n, int total, int[] arr) {
		this.n = n;
		this.total = total;
		dfs(0, 0, arr);
		return answer;
	}

	public void dfs(int L, int sum, int[] arr) {
		if (flag) {
			return;
		}
		if (sum > total / 2) {
			return;
		}
		if (L == n) {
			if ((total - sum) == sum) {
				answer = "YES";
				flag = true;
				return;
			}
		} else {
			dfs(L + 1, sum + arr[L], arr);
			dfs(L + 1, sum, arr);
		}
	}
}

public class N01_SubsetSameSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String num = bf.readLine();
		int n = Integer.parseInt(num);
		int total = 0;
		String str = bf.readLine();
		String[] strArr = str.split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
			total += arr[i];
		}

//		int n = 6;
//		int[] arr = { 1, 3, 5, 6, 7, 10 };

		SubsetSameSum sol = new SubsetSameSum();
		System.out.println(sol.solution_dfs(n, total, arr));
	}
}
