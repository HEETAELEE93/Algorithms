package no1;

public class No1 {
	public static void main(String[] args) {
		No1 sol = new No1();
		long num = 9949999;
		System.out.println("Solution: return value of the method is " + sol.solution(num) + " .");
	}
	public long solution(long num) {
		num++;
        long digit = 1;
        while (num / digit % 10 == 0) {
            num += digit;
            digit *= 10;
        }
        return num;
    }
}
