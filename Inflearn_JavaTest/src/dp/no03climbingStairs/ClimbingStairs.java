package dp.no03climbingStairs;

class Solution {
	public int climbStairs(int n) {
		int[] dp = new int[n+1];
		
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		return dp[n];
	}
	
	public int climbStairs2(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		return climbStairs(n-2) + climbStairs(n-1);
	}
	
}


public class ClimbingStairs {
	public static void main(String[] args) {
		int n = 10;
		Solution s = new Solution();
		System.out.println(s.climbStairs(n));
		
		System.out.println(s.climbStairs2(n));
		
	}
}
