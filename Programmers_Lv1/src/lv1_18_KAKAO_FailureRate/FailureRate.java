/*
 * 2019 KAKAO BLIND 실패율 * Failure Rate
문제 설명
슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 
원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 
역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.

실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

제한사항
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages의 길이는 1 이상 200,000 이하이다.
stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

입출력 예
N	stages	result
5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
4	[4,4,4,4,4]	[4,1,2,3]

입출력 예 설명
입출력 예 #1
1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.
1 번 스테이지 실패율 : 1/8

2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
2 번 스테이지 실패율 : 3/7

마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
3 번 스테이지 실패율 : 2/4
4번 스테이지 실패율 : 1/2
5번 스테이지 실패율 : 0/1
각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.

[3,4,2,1,5]

입출력 예 #2
모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
[4,1,2,3]

 */
package lv1_18_KAKAO_FailureRate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		// N:5)  
		// stages: 2,1,2,6,2,4,3,3
		// stages: 1,2,2,2,3,3,4,6
		// 1) 1/8
		// 2) 3/7
		// 3) 2/4
		// 4) 1/2
		// 5) 0/1
		// 6) 1
		// 실패율 높은것부터 : 3,4,2,1,5
		// hashmap 선언
		Map<Integer, Float> result = new HashMap<Integer, Float>();

		int a = 0;
		int range = stages.length;
		Arrays.sort(stages);
		
		// 해쉬맵에 실패율을 구해서 넣기
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < stages.length; j++) {
				if(i == stages[j]) {
					a++;
				}
			}
			// 해쉬맵 순서대로 N까지 값을 구한거 넣기 / 0 예외처리
			if(a == 0) {
				result.put(i, 0f);
			} else {
				result.put(i, (float)a / (float)range);
			}
			// range는 a값 만큼 빼줘야 그 다음번째 값을 구할 수 있음
			range -= a;
			a = 0;
		}
		
		// 실패율 구한거
		//iteratorUsingForEach((HashMap) result);
		
		// value값으로 내림차순 정렬, value가 같으면 key 오름차순 정렬
		List<Entry<Integer, Float>> list = new LinkedList<Entry<Integer,Float>>(result.entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Float>>() {
			
			@Override
			public int compare(Entry<Integer, Float> o1, Entry<Integer, Float> o2) {
				// 내림차순
				return o2.getValue().compareTo(o1.getValue());
				// 오름차순
				// return o1.getValue().compareTo(o2.getValue());
			}
		});
		Iterator<Entry<Integer, Float>> iter = list.iterator();

		for(int i = 0; i < list.size(); i++) {
			answer[i] = iter.next().getKey();
		}
		
		// sort by value 오름차순
//		LinkedHashMap<Integer, Float> linkMap = 
//				result.entrySet().stream().sorted(Entry.comparingByValue()).
//				collect(Collectors.toMap(Entry::getKey, Entry::getValue,
//						(x,y) -> x, LinkedHashMap::new));
//		System.out.println(linkMap);

		return answer;
	}
	
	// hashmap 열거 방법
	static void iteratorUsingForEach(HashMap<Integer, Float> map) {
		Set<Map.Entry<Integer, Float>> entries = map.entrySet();
		for(Map.Entry<Integer, Float> entry : entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}

public class FailureRate {
	public static void main(String[] args) {
		Solution s = new Solution();
		int N = 5;	// n+1 = 6
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};	// 8
		System.out.println(Arrays.toString(s.solution(N, stages)));
	}
}