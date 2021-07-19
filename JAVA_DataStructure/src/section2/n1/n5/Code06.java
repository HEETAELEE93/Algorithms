package section2.n1.n5;

import java.util.Scanner;

public class Code06 {

	// 다항식의 배열을 만들어서 객체 생성
	static Polynomial[] polys = new Polynomial[10];
	// 현재 입력되어서 저장된 다항식 갯수
	static int n = 0;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			System.out.print("$ ");
			String command = kb.next();
			if (command.equals("create")) {
				// next()는 String이지만 charAt(0)을 써서
				// 첫번째 char를 받아 char형으로 가져올 수 있음
				char name = kb.next().charAt(0);

//				Polynomial p = new Polynomial();
//				p.name = name;
//				p.nTerms = 0;
//				polys[n] = p;

				// 다항함수를 표현하는 객체 생성, 배열에 저장
				polys[n] = new Polynomial();
				polys[n].name = name;
				polys[n].terms = new Term[10];
				polys[n].nTerms = 0;
				n++;
			} else if (command.equals("add")) { // add f 2 3
				char name = kb.next().charAt(0);
				int index = find(name);
				if (index == -1) {
					System.out.println("No Search polynomial exists");
				} else {
					int c = kb.nextInt(); // 2
					int e = kb.nextInt(); // 3
					addTerm(polys[index], c, e);
				}
			} else if (command.equals("calc")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if (index == -1) {
					System.out.println("No Search polynomial exists");
				} else {
					int x = kb.nextInt();
					int result = calcPolynomial(polys[index], x);
					System.out.println(result);
				}
			} else if (command.equals("print")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if (index == -1) {
					System.out.println("No Search polynomial exists");
				} else {
					printPolynomial(polys[index]);
				}
			} else if (command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}

	private static int calcPolynomial(Polynomial p, int x) {
		int result = 0;
		for (int i = 0; i < p.nTerms; i++) {
			result += calcTerm(p.terms[i], x);
		}
		return result;
	}

	private static int calcTerm(Term term, int x) {
		// 지수 함수 계산 함수
		return (int) (term.coef * Math.pow(x, term.expo));
	}

	private static void printPolynomial(Polynomial p) {
		for (int i = 0; i < p.nTerms; i++) {
			printTerm(p.terms[i]);
			if(i < p.nTerms-1) {
				System.out.print("+");
			}
		}
		System.out.println();
	}

	private static void printTerm(Term term) {
		if (term.coef == 1) {
			System.out.print("x^" + term.expo);
		} else if(term.coef == -1) {
			System.out.print("-x^" + term.expo);
		} else if(term.expo == 0) {
			System.out.print(term.coef);
		}
		
		else {
			System.out.print(term.coef + "x^" + term.expo);
		}
	}

	private static void addTerm(Polynomial p, int c, int e) {
		int index = findTerm(p, e);
		if (index != -1) { // 이미 e차수가 있는경우 차수만 더함
			p.terms[index].coef += c; // -5x^3 +5x^3인 경우 생각해야 함
			if (p.terms[index].coef == 0) {

			}
		} else {
			// e차수가 없으면 배열 중간에 들어가야 하니까 원래 배열에 있는
			// 것들을 뒤로 밀어버림
			int i = p.nTerms - 1; // -> 맨 마지막 항
			while (i >= 0 && p.terms[i].expo < e) {
				p.terms[i + 1] = p.terms[i];
				i--;
			}
			p.terms[i + 1] = new Term();
			p.terms[i + 1].coef = c;
			p.terms[i + 1].expo = e;
			p.nTerms++;
		}
	}

	// p값의 다항식과 e의 차수를 받아서 이미 있는지 없는지 검사
	private static int findTerm(Polynomial p, int e) {
		// pterms[i].expo가 e보다 클때만 돔
		// e보다 작아지면 차수에 대해 내림차순이므로 되어있으므로 뒤는 볼 필요도 없음
		for (int i = 0; i < p.nTerms && p.terms[i].expo >= e; i++)
			if (p.terms[i].expo == e)
				return i;
		return -1;
	}

	private static int find(char name) {
		for (int i = 0; i < n; i++)
			if (polys[i].name == name)
				return i;
		return -1;
	}
}
