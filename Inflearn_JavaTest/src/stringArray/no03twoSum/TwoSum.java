package stringArray.no03twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Twosum1 {
	public int[] twoSum(int[] nums, int target) {
		double start = System.nanoTime();
		int[] answer = new int[2];

		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				answer[0] = hm.get(nums[i]);
				answer[1] = i;
			} else {
				hm.put(target - nums[i], i);
			}
		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
		return answer;
	}
}

class MyTwosum {
	public int[] twoSum(int[] nums, int target) {
		double start = System.nanoTime();

		int[] answer = new int[2];
		loop: for (int i = 0; nums[i] < target; i++) {
			for (int j = i + 1; nums[j] < target; j++) {
				if (nums[i] + nums[j] == target) { 
					answer[0] = i;
					answer[1] = j;
					break loop;
				}
			}
		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
		return answer;
	}
}

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		
//		int[] nums = new int[1000000];
//		int target = 412345;
//		nums[0] = 1;
//		for(int i = 1; i < 1000000; i++) {
//			nums[i] = i+1;
//		}
		
		Twosum1 ts = new Twosum1();
		System.out.println(Arrays.toString(ts.twoSum(nums, target)));

		MyTwosum t = new MyTwosum();
		System.out.println(Arrays.toString(t.twoSum(nums, target)));

	}
}
