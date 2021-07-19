package stringArray.no07JewelsAndStones;

import java.util.HashSet;
import java.util.Set;

class JewelsAndStones1 {
	public int solve(String jewels, String stones) {
		double start = System.nanoTime();
		int result = 0;
		
		Set<Character> hs = new HashSet<Character>();
		
		for(char i : jewels.toCharArray()) {
			hs.add(i);
		}
		for(char i : stones.toCharArray()) {
			if(hs.contains(i)) {
				result++;
			}
		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		return result;
	}
}

public class JewelsAndStones {
	public static void main(String[] args) {
		String jewels = "aA";
		String stones = "aAAbbbb";
		
		JewelsAndStones1 jw1 = new JewelsAndStones1();
		System.out.println(jw1.solve(jewels, stones));
	}
}
