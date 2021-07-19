/*
 * 완주하지 못한 선수
 */

/*
 문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.

입출력 예
participant								completion							return
[leo, kiki, eden]						[eden, kiki]						leo
[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
[mislav, stanko, mislav, ana]			[stanko, ana, mislav]				mislav

입출력 예 설명

예제 #1
leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

*/

package lv1_01_Sunsu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 배열 sort 함수를 사용해 정렬하고 participant와 completion과 비교하여 맞지 않으면 출력
 */
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i = 0;
        for(i = 0; i < completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		return participant[i];
        	}
        }
        return participant[i];
    }
}

/*
 * 해시 함수를 사용하여 출력
 */
class Solution1 {
	public String solution1(String[] participant, String[] completion) {
		String answer = "";
		// 입력값 출력확인
        System.out.println("participant: " + Arrays.toString(participant));
        System.out.println("completion: " + Arrays.toString(completion));
    	
        // HashMap 선언
        Map<String, Integer> hm = new HashMap<>();
        
        // participant를 HashMap에 입력
        for(String part : participant) {
        	// null값이면 (이름, 1)로 입력
        	if(hm.get(part) == null) {
        		hm.put(part, 1);
        	}else {		// 중복값이면 value에 +1하기
        		hm.put(part, hm.get(part)+1);
        	}
        	System.out.println(part + " " + hm.get(part));
        }
        
        System.out.println("-------");
        
        // completion은 key값이 맞으면 value를 -1하기
        for(String comp : completion) {
        	hm.put(comp, hm.get(comp)-1);
        	System.out.println(comp + " " + hm.get(comp));
        }
        
        System.out.println("----");
        
        // +1, -1씩 했으니 1이 남아 있으면 그 놈이 답임
        for(String result : hm.keySet()) {
        	if(hm.get(result) == 1) {
        		answer = result;
        	}
        }

        return answer;
    }
}

public class Sunsu {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
//		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		Solution1 s = new Solution1();
		System.out.println(s.solution1(participant, completion));
	}
}
