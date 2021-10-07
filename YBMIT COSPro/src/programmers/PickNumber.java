package programmers;

import java.util.Arrays;

public class PickNumber {

	public static void main(String[] args) {
		PickNumber sol = new PickNumber();
        int[] arr = {9, 11, 9, 6, 4, 19};
        int K = 4;
        int ret = sol.solution(arr, K);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + "입니다.");
	}
	
	public int solution(int[] arr, int K) {
        int answer = 1000;
        int tmp = 0;
        Arrays.sort(arr);	// 4 6 9 9 11 19 20
        
        for(int i = 0; i < arr.length - K - 1; i++) {
        	tmp = arr[i + K - 1] - arr[i];
        	answer = Math.min(answer, tmp);
        }
        
        return answer;
    }

}
