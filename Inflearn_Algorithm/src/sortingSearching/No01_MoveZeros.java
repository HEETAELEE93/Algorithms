package sortingSearching;

class MoveZero {
	public void solve(int[] nums) {
		int cnt = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[cnt] = nums[i];
				cnt++;
			}
		}
		for(int i = cnt; i < nums.length; i++) {
			nums[i] = 0;
		}
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}
}

public class No01_MoveZeros {
	public static void main(String[] args) {
		int[] nums = {0,3,2,0,8,5};
		MoveZero sol = new MoveZero();
		sol.solve(nums);
	}
}
