package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Solution {
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, -1, 0, 1};
    public int solution(int[][] garden) {
        int answer = 0;
        
        int len = garden.length;
        Set<int[]> set = new HashSet<int[]>();
        List<int[]> list = new ArrayList<int[]>();
        int cnt = 0;
        
        while(cnt < len*len) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (garden[i][j] == 1) {
						int[] arr = {i,j};
						if(!list.contains(arr))
							list.add(arr);
						cnt++;
					}
				}
			}
			if(cnt == len*len) {
				break;
			}
			Iterator<int[]> iter = list.iterator();
			while(iter.hasNext()) {
				int[] arr = iter.next();
				
				for(int i = 0; i < 4; i++) {
					int x = arr[0] + dx[i];
					int y = arr[1] + dy[i];
					if (x < 0 || x >= len || y < 0 || y >= len) {
						continue;
					}
					garden[x][y] = 1;
				}
			}
			
			answer++;
        }
        
//        while(cnt < len*len) {
//			for (int i = 0; i < len; i++) {
//				for (int j = 0; j < len; j++) {
//					if (garden[i][j] == 1) {
//						int[] arr = {i,j};
//						if(!set.contains(arr))
//							set.add(arr);
//						cnt++;
//					}
//				}
//			}
//			if(cnt == len*len) {
//				break;
//			}
//			Iterator<int[]> iter = set.iterator();
//			while(iter.hasNext()) {
//				int[] arr = iter.next();
//				
//				for(int i = 0; i < 4; i++) {
//					int x = arr[0] + dx[i];
//					int y = arr[1] + dy[i];
//					if (x < 0 || x >= len || y < 0 || y >= len) {
//						continue;
//					}
//					garden[x][y] = 1;
//				}
//			}
//			
//			answer++;
//        }
        
        return answer;
    }
}

public class makingFlower {
	public static void main(String[] args) {
		Solution sol = new Solution();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

	}
}
