package section2.n2.n1;

import java.util.Scanner;

public class Code07 {

	// 다항식의 배열을 만들어서 객체 생성
	static Polynomial2[] polys = new Polynomial2[10];
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
				polys[n] = new Polynomial2();
				polys[n].name = name;
				polys[n].terms = new Term2[10];
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
					polys[index].addTerm(c, e);
				}
			} else if (command.equals("calc")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if (index == -1) {
					System.out.println("No Search polynomial exists");
				} else {
					int x = kb.nextInt();
					int result = polys[index].calcPolynomial(x);
					System.out.println(result);
				}
			} else if (command.equals("print")) {
				char name = kb.next().charAt(0);
				int index = find(name);
				if (index == -1) {
					System.out.println("No Search polynomial exists");
				} else {
					polys[index].printPolynomial();
				}
			} else if (command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}


	private static int find(char name) {
		for (int i = 0; i < n; i++)
			if (polys[i].name == name)
				return i;
		return -1;
	}
}
