package recursion;

class NQ {
	int N = 8;
	int[] cols = new int[N + 1];	// 열번호
/*
 return-type queens( argument ) {
	if ( non-promissing ) {
		report failure and return;
	} else if ( success ) {
		report answer and return;
	} else {
		visit children recursively;
	}
}
 */
	boolean queens(int level) {
		if (!promising(level)) {
			return false;
		} else if (level == N) { // success
//			for (int i = 1; i <= N; i++) {
//				System.out.print(cols[i] + " ");
//			}
//			return true;
			
			for(int i = 1; i <= N; i++) {
				System.out.print(cols[i] + " " );
			}
			System.out.println();
			return false;
		} else {
			for (int i = 1; i <= N; i++) {
				cols[level + 1] = i;
				if (queens(level + 1)) {
					return true;
				}
			}
			return false;
		}
	}

	boolean promising(int level) {
		for (int i = 1; i < level; i++) {
			if (cols[i] == cols[level]) {	// 같은 열
				return false;
			} else if (level - i == Math.abs(cols[level] - cols[i])) { // 대각선
				return false;
			}
		}
		return true;
	}
}

public class Nqueen {
	public static void main(String[] args) {
		NQ n = new NQ();
		//System.out.println(n.queens(0));
		n.queens(0);
	}
}
