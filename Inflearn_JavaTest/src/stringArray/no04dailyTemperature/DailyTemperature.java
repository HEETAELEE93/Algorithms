package stringArray.no04dailyTemperature;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

class DailyTemp {
	public int[] dailyTemperatures(int[] temper) {
		double start = System.nanoTime();
		int[] answer = new int[temper.length];
		
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = 0; i < temper.length; i++) {
			while(!st.isEmpty() && temper[st.peek()] < temper[i]) {
				int idx = st.pop();
				answer[idx] = i - idx;
			}
			st.push(i);
		}
		
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
		return answer;
	}
}

class MyDailyTemp {
	public int[] dailyTemperatures(int[] temp) {
		double start = System.nanoTime();
		
		int[] answer = new int[temp.length];
		for(int i = 0; i < temp.length; i++) {
			for(int j = i + 1; j < temp.length; j++) {
				if(temp[i] < temp[j]) {
					answer[i] = j - i;
					break;
				}
			}
		}
		
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
		return answer;
	}
}

public class DailyTemperature {
	public static void main(String[] args) {
//		int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] nums = new int[10000];
		
		// 숫자 범위 랜덤 생성
		Random Rand = new Random();
		for(int i = 0; i < 1000; i++) {
			int randomNum = 30 + Rand.nextInt((100 - 30) + 1);
			nums[i] = randomNum;
		}
//		System.out.println(Arrays.toString(nums));
		
		DailyTemp dt = new DailyTemp();
		System.out.println(Arrays.toString(dt.dailyTemperatures(nums)));
		
		MyDailyTemp mdt = new MyDailyTemp();
		System.out.println(Arrays.toString(mdt.dailyTemperatures(nums)));
	}
}
