package stringArray.no02MoveZero;

class MoveZeros {
	public void moveZeroes(int[] nums) {
		int idx = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[idx] = nums[i];
				idx++;
			}
		}
		for(int i = idx; i < nums.length; i++) {
			nums[i] = 0;
		}
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}
}

public class MoveZero {
	public static void main(String[] args) {
		int[] input = {0,1,0,3,12};
		MoveZeros mo = new MoveZeros();
		mo.moveZeroes(input);
	}
}
