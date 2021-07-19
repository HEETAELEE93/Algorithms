package sortingSearching;

import java.util.Arrays;

/*
	public int compareTo(){
		return A.compareTo(B);
	}
	A == B -> 0
	A > B -> 1
	A < B -> -1 (ex. 1 2 3 이런식이면 2-3은 -1 return)
 */

class LogFileDataResorting {
	public String[] solve(String[] logs) {
		Arrays.sort(logs, (s1, s2) -> {
			String[] split1 = s1.split(" ", 2);
			String[] split2 = s2.split(" ", 2);
			
			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
			
			if(!isDigit1 && !isDigit2) { // 모두 문자
				int comp = split1[1].compareTo(split2[1]); // 오름차순
				if(comp == 0) { // 뒷글자들 모두 같다면 앞에껄로 비교
					return split1[0].compareTo(split2[0]);
				} else {
					return comp;
				}
			} else if(isDigit1 && isDigit2) { // 모두 숫자
				return 0;
			} else if(isDigit1 && !isDigit2) { // 첫번째 숫자, 두번째 문자
				return 1;
			} else { // 첫번째 문자, 두번째 숫자
				return -1;
			}
		});
		return logs;
	}
}

public class No07_LogFileDataResorting {
	public static void main(String[] args) {
		String[] logs = {
			"dig1 8 2 3 1",
			"let1 abc cat",
			"dig1 2 5",
			"let2 good dog book",
			"let3 abc zoo" 
		};
		LogFileDataResorting sol = new LogFileDataResorting();
		System.out.println(Arrays.toString(sol.solve(logs)));
		
	}
}
