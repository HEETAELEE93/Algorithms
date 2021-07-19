package section2.n2.n2;
// 하나의 다항식을 표현하기 위한 클래스
public class Polynomial3 {
	public char name;	// 다항식 이름
	public Term3[] terms;// 다항식을 구성하는 항들을 저장할 배열
	public int nTerms = 0;	// 다항식 구성하는 항 갯수
	
	public Polynomial3() {
		nTerms = 0;
		terms = new Term3[100];
	}
	
	public Polynomial3(char name) {
		this.name = name;
		nTerms = 0;
		terms = new Term3[100];
	}
	
	public int calcPolynomial(int x) {
		int result = 0;
		for (int i = 0; i < nTerms; i++) {
			result += terms[i].calcTerm(x);
		}
		return result;
	}

	public void printPolynomial() {
		for (int i = 0; i < nTerms; i++) {
			terms[i].printTerm();
			if(i < nTerms-1) {
				System.out.print("+");
			}
		}
		System.out.println();
	}
	
	public void addTerm(int c, int e) {
		int index = findTerm(e);
		if (index != -1) { // 이미 e차수가 있는경우 차수만 더함
			terms[index].coef += c; // -5x^3 +5x^3인 경우 생각해야 함
			if (terms[index].coef == 0) {

			}
		} else {
			// e차수가 없으면 배열 중간에 들어가야 하니까 원래 배열에 있는
			// 것들을 뒤로 밀어버림
			int i = nTerms - 1; // -> 맨 마지막 항
			while (i >= 0 && terms[i].expo < e) {
				terms[i + 1] = terms[i];
				i--;
			}
			terms[i + 1] = new Term3(c, e);
//			terms[i + 1].coef = c;
//			terms[i + 1].expo = e;
			nTerms++;
		}
	}

	// p값의 다항식과 e의 차수를 받아서 이미 있는지 없는지 검사
	public int findTerm(int e) {
		// pterms[i].expo가 e보다 클때만 돔
		// e보다 작아지면 차수에 대해 내림차순이므로 되어있으므로 뒤는 볼 필요도 없음
		for (int i = 0; i < nTerms && terms[i].expo >= e; i++)
			if (terms[i].expo == e)
				return i;
		return -1;
	}
}
