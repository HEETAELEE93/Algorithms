package BigONotation;

public class StringSort {
	public static final int C = 26;

	private static void printSortedStings(int k) {
		printSortedStings(k, "");
	}

	private static void printSortedStings(int k, String prefix) {
		if (k == 0) {
			if(isInOrder(prefix)) {
				System.out.println(prefix);
			}
		} else {
			for (int i = 0; i < C; i++) {
				char c = ithLetter(i);
				printSortedStings(k - 1, prefix + c);
			}
		}
	}

	private static boolean isInOrder(String s) {
		for(int i = 1; i < s.length(); i++) {
			int prev = ithLetter(s.charAt(i-1));
			int curr = ithLetter(s.charAt(i));
			if(prev > curr)
				return false;
		}
		return true;
	}

	private static char ithLetter(int i) {
		return (char) (((int)'a') + i);
	}

	public static void main(String[] args) {
		printSortedStings(2);
	}
}
