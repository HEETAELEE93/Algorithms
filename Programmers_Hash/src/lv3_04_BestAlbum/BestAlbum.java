/*
 * 베스트 앨범 Best Album
 */
/*
문제 설명
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.

입출력 예
genres									plays						return
[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

입출력 예 설명
classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

고유 번호 3: 800회 재생
고유 번호 0: 500회 재생
고유 번호 2: 150회 재생

pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

고유 번호 4: 2,500회 재생
고유 번호 1: 600회 재생
따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 */

package lv3_04_BestAlbum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		Map<String, Integer> sumMap = new TreeMap<String, Integer>();

		for (int i = 0; i < genres.length; i++) {
			sumMap.put(genres[i], 0);
		}
		// 각 genre 합
		for (int i = 0; i < genres.length; i++) {
			sumMap.put(genres[i], sumMap.get(genres[i]) + plays[i]);
		}
//		System.out.println(sumMap);

		// genre별 내림차순 정렬
		List<String> genlist = new ArrayList<String>();
		genlist.addAll(sumMap.keySet());

		Collections.sort(genlist, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return sumMap.get(o2).compareTo(sumMap.get(o1));
			}
		});
//		System.out.println(genlist);

		answer = new int[genlist.size() * 2];

		List<Integer> genreList = new ArrayList<Integer>();
		Map<Integer, Integer> playMap = new TreeMap<Integer, Integer>();
		int ansCnt = 0;
		while (!genlist.isEmpty()) {
			String genre = genlist.remove(0);
			for (int i = 0; i < genres.length; i++) {
				if (genres[i].equals(genre)) {
					genreList.add(i);
				}
			}
			while (!genreList.isEmpty()) {
				int a = genreList.remove(0);
				playMap.put(a, plays[a]);
			}
			List<Integer> playlist = new ArrayList<Integer>();
			playlist.addAll(playMap.keySet());

			Collections.sort(playlist, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return playMap.get(o2).compareTo(playMap.get(o1));
				}

			});
			// playlist 2개
			if (!playlist.isEmpty()) {
				int a = playlist.remove(0);
				answer[ansCnt++] = a;
			}
			if (!playlist.isEmpty()) {
				int b = playlist.remove(0);
				answer[ansCnt++] = b;
			}

			genreList.clear();
			playMap.clear();
		}

		if (ansCnt <= answer.length) {
			int[] newAnswer = new int[ansCnt];
			for (int i = 0; i < ansCnt; i++) {
				newAnswer[i] = answer[i];
			}
			return newAnswer;
		}

		return answer;
	}
}

class Solution2 {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		return answer;
	}
}

public class BestAlbum {
	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
//		return 4, 1, 3, 0

		String[] genres2 = { "classic", "classic", "classic", "classic", "pop" };
		int[] plays2 = { 500, 150, 800, 800, 2500 };
//		return 4,2,3

		String[] genres3 = { "a", "a", "a", "b", "b" };
		int[] plays3 = { 3, 3, 3, 2, 2 };

		Solution s = new Solution();
//		System.out.println(Arrays.toString(s.solution(genres, plays)));
//		System.out.println(Arrays.toString(s.solution(genres2, plays2)));
		System.out.println(Arrays.toString(s.solution(genres3, plays3)));
	}
}
