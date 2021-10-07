package programmers;

public class Memo {

	public static void main(String[] args) {
		Memo sol = new Memo();
		int K = 10;
        String[] words = {new String("nice"), new String("happy"), new String("hello"), new String("world"), new String("hi")};
        int ret = sol.solution(K, words);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
	}

	public int solution(int K, String[] words) {
		int answer = 0;
		
		int tmp = 0;
		tmp = K - words[0].length() + 1;
		for(int i = 1; i < words.length; i++) {
			int len = words[i].length();
			if(len <= tmp) {
				
			}
		}
		
		return answer;
	}
}
