package stringArray.no10plusOne;

import java.util.Arrays;

class Solution {
	public int[] plusOne(int[] digits) {
		double start = System.nanoTime();
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				break;
			} else {
				digits[i] = 0;
			}
		}

		if (digits[0] == 0) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			double end = System.nanoTime();
			System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
			return result;
		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		return digits;
	}
}

class MySolution {
	public int[] myPlusOne(int[] digits) {
		double start = System.nanoTime();
		int[] result;

		String numStr = "";
		for (int i = 0; i < digits.length; i++) {
			numStr += digits[i];
		}

		int num = Integer.parseInt(numStr);
		num++;
		System.out.println(numStr);
		
		
		int digi = (int) (Math.log10(num) + 1);

		if (digi > digits.length) {
			result = new int[digits.length + 1];
		} else {
			result = new int[digits.length];
		}

		for (int i = digi - 1; i >= 0; i--) {
			result[i] = num % 10;
			num /= 10;
		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
		return result;
	}
}

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] digits2 = { 9, 9, 9, 9, 9, 9, 9, 9, 9 };

		Solution s = new Solution();
		System.out.println(Arrays.toString(s.plusOne(digits)));
		System.out.println(Arrays.toString(s.plusOne(digits2)));

		MySolution ms = new MySolution();
		System.out.println(Arrays.toString(ms.myPlusOne(digits)));
		System.out.println(Arrays.toString(ms.myPlusOne(digits2)));
	}
}
