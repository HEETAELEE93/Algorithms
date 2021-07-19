package dp.no02coinChange;

import java.util.Arrays;

class Solution {
	public int coinChange(int[] coins, int amount) {
		int max = amount + 1;

		int[] dp = new int[max];

		Arrays.fill(dp, max);
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}
}

public class CoinChange {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;

		Solution s = new Solution();
		System.out.println(s.coinChange(coins, amount));

	}
}
