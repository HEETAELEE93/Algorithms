/*
문제 설명
데이터 처리 전문가가 되고 싶은 어피치는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 
최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 
문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 
더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
간단한 예로 aabbaccc의 경우 2a2ba3c(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 
이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 
예를 들면, abcabcdede와 같은 문자열은 전혀 압축되지 않습니다. 
어피치는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 
더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.

예를 들어, ababcdcdababcdcd의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 
2개 단위로 잘라서 압축한다면 2ab2cd2ab2cd로 표현할 수 있습니다. 
다른 방법으로 8개 단위로 잘라서 압축한다면 2ababcdcd로 표현할 수 있으며, 
이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, abcabcdede와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 abcabc2de가 되지만, 
3개 단위로 자른다면 2abcdede가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 
이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 
위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 
가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

제한사항
s의 길이는 1 이상 1,000 이하입니다.
s는 알파벳 소문자로만 이루어져 있습니다.

입출력 예
s							result
"aabbaccc"					7
"ababcdcdababcdcd"			9
"abcabcdede"				8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd"			17

입출력 예에 대한 설명
입출력 예 #1
문자열을 1개 단위로 잘라 압축했을 때 가장 짧습니다.

입출력 예 #2
문자열을 8개 단위로 잘라 압축했을 때 가장 짧습니다.

입출력 예 #3
문자열을 3개 단위로 잘라 압축했을 때 가장 짧습니다.

입출력 예 #4
문자열을 2개 단위로 자르면 abcabcabcabc6de 가 됩니다.
문자열을 3개 단위로 자르면 4abcdededededede 가 됩니다.
문자열을 4개 단위로 자르면 abcabcabcabc3dede 가 됩니다.
문자열을 6개 단위로 자를 경우 2abcabc2dedede가 되며, 이때의 길이가 14로 가장 짧습니다.

입출력 예 #5
문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
따라서 주어진 문자열을 x / ababcdcd / ababcdcd 로 자르는 것은 불가능 합니다.
이 경우 어떻게 문자열을 잘라도 압축되지 않으므로 가장 짧은 길이는 17이 됩니다.

 */

package lv1_20_KAKAO_StringCompression;

import java.util.HashMap;
import java.util.Map;

class Solution {
	// singleton
	private static Solution instance;

	public static Solution getInstance() {
		if (instance == null) {
			instance = new Solution();
		}
		return instance;
	}

	public Solution() {
		super();
	}
	// end singleton

	public int solution(String s) {
		int answer = 0;

		// subBefore랑 resultString랑 같으면 더할 변수
		int count = 1;
		// 자른 string을 담을 변수
		String subBefore = "";
		// 결과값을 넣을 String
		String resultString = "";

		Map<Integer, String> stringMap = new HashMap<Integer, String>();

		if (s.length() == 1) {
			answer = 1;
		} else {
			// 문자열 길이 1/2까지만 돌림. i는 문자열 자를 단위
			for (int i = 1; i <= s.length() / 2; i++) {
				// j가 문자열의 길이 / i 까지의 길이만큼만 늘어나게함
				for (int j = 1; j <= s.length() / i; j++) {
					// sub 비교할 값
					String sub = s.substring((j - 1) * i, j * i);

					if (j > 1) {
						if (subBefore.equals(sub)) {
							count++;
						} else {
							if (count == 1) {
								resultString += subBefore;
							} else {
								resultString += count + subBefore;
								count = 1;
							}
						}
					}
					subBefore = sub;
					if (j == s.length() / i) {
						if (count == 1) {
							resultString += sub;
						} else {
							resultString += count + sub;
						}
					}
					if (j == s.length() / i && s.length() % i != 0) {
						String subLast = s.substring(j * i);
						resultString += subLast;
					}
				}
				stringMap.put(i, resultString);
				count = 1;
				resultString = "";
			}
			answer = stringMap.get(1).length();
			for (int i = 1; i <= stringMap.size(); i++) {
				if (answer > stringMap.get(i).length()) {
					answer = stringMap.get(i).length();
				}
			}
		}
		return answer;
	}
}

public class StringCompression {
	public static void main(String[] args) {
		System.out.println(Solution.getInstance().solution("abcabcabcabcdededededede"));

//		Solution a = new Solution();
//		String s = "aabbaccc";
//		System.out.println(a.solution(s));
	}
}