package no2_array;

import java.util.ArrayList;
import java.util.Scanner;

class FlipPrimeNum {
	public ArrayList<Integer> solution(int n, int[] arr){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i : arr) {
			int a = 0;
			while(i != 0) {
				a *= 10;
				a += i % 10;
				i /= 10;
			}
			if(isPrime(a) && a >= 2) {
				list.add(a);
			}
		}
		return list;
	}

	boolean isPrime(int n) {
		int[] ch = new int[n+1];
		for(int i = 2; i <= n; i++) {
			if(ch[i] == 0) {
				if(i == n) {
					break;
				}
				for(int j = i; j <= n; j = j+i) {
					ch[j] = 1;
					if(j == n) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

public class N06_FlipPrimeNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 9;
		int[] arr = {32, 55, 62, 20, 250, 370, 200, 30, 100};
		
		FlipPrimeNum sol = new FlipPrimeNum();
		for(int x : sol.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}
