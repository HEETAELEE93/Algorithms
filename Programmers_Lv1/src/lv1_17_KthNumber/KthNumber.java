/*
 * K번째 수 * Kth Number
문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 
return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.

입출력 예
array					commands							return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
 */

package lv1_17_KthNumber;

import java.util.Arrays;

// My Solution
class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		// 1. commands[n][0] = i / commands[n][1] = j / commands[n][2] = k
		for(int a = 0; a < commands.length; a++) {
			int i = commands[a][0];
			int j = commands[a][1];
			int k = commands[a][2];
			
			int range = j-i+1;
			int[] cut = new int[range];
			for(int b = 0; b < range; b++) {
				cut[b] = array[i-1];
				i++;
			}
			Arrays.sort(cut);
//			System.out.println("cut은 " + Arrays.toString(cut));
			answer[a] = cut[k-1];
		}
		return answer;
	}
}

/* Use <copyOfRange>
 * 첫번째 매개변수로 복사할 배열 전달 받고
 * 두번째 매개변수로 원본 배열에서 복사할 시작 인덱스 전달 받고
 * 세번째 매개변수로 마지막으로 복사될 인덱스를 전달받는다
 */
class Solution1{
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i = 0; i < commands.length; i++) {
			int[] cut = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(cut);
			answer[i] = cut[commands[i][2]-1];
		}
		
		return answer;
	}
}

public class KthNumber {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] array = {1,5,2,6,3,7,4};	// 7개
		int[][] commands = {
				{2,5,3},	// i, j, k
				{4,4,1},
				{1,7,3}
		};
		System.out.println(Arrays.toString(s.solution(array, commands)));
	}
}