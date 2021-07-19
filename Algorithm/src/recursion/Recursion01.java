package recursion;

import java.util.Scanner;

public class Recursion01 {
	// Euclid Method
	public static int gcd(int m, int n) {
		if (m < n) {
			int tmp = m;
			m = n;
			n = tmp;
		}
		if (m % n == 0)
			return n;
		else
			return gcd(n, m % n);
	}
	
	// 문자열 길이
	public static int length(String str) {
		if(str.equals(""))
			return 0;
		else
			return 1 + length(str.substring(1));
	}
	
	// 문자열 프린트
	public static void printchars(String str) {
		if(str.length()==0)
			return;
		else {
			// charAt = 이 문자열의 첫번째를 리턴
			System.out.print(str.charAt(0));
			printchars(str.substring(1));
		}
	}
	
	// 문자열 뒤집어 프린트
	public static void printCharsReverse(String str) {
		if(str.length() == 0)
			return;
		else {
			printCharsReverse(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}
	
	// 2진수로 변환하여 출력
	public static void printBinary(int n) {
		if(n < 2)
			System.out.print(n);
		else {
			printBinary(n/2);
			System.out.print(n%2);
		}
	}
	
	// 배열의 합
	public static int sum(int n, int[] data) {
		if(n<=0)
			return 0;
		else
			return sum(n-1, data) + data[n-1];
	}
	
	// 데이터파일로부터 n개의 정수 읽기
	public static void readFrom(int n, int[] data, Scanner in) {
		if(n==0) {
			return;
		}
		else {
			readFrom(n-1, data, in);
			data[n-1] = in.nextInt();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(30, 10));
		printchars("abc");
		System.out.println();
		printCharsReverse("abc");
		System.out.println();
		System.out.print("printBinary : ");
		printBinary(4);
		System.out.println();
		System.out.print("Array Sum : ");
		int[] data = {1,2,3};
		System.out.println(sum(3, data));
		
	}
}