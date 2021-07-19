package No1;

class Solution {
	public int solution(String p, String s) {
		int answer = 0;
		
		for(int i = 0; i < p.length(); i++) {
			int pi = p.charAt(i);
			int si = s.charAt(i);
			
			if(pi - si > 5) {
				answer += (si+10) - pi;
			} else if(pi - si >= 0 && pi - si <= 5) {
				answer += pi - si;
			} else if(pi - si < 0 && pi - si > -5) {
				answer += Math.abs(pi - si);
			} else {
				answer += (pi+10) - si;
			}
		}
		return answer;
	}
}


public class No1 {
	public static void main(String[] args) {
		String p = "82195";
		String s = "64723";
		String p1 = "0000000000";
		String s1 = "9191919191";
		Solution sol = new Solution();
		System.out.println(sol.solution(p1, s1));
	}
}
