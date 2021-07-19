/*
 * 직사각형 별 찍기
 */

package lv1_10_Star;
import java.util.Scanner;

public class lv1_07_Star {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i = 1; i <= b; i++) {
			for(int j = 1; j <= a; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		sc.close();
	}
}
