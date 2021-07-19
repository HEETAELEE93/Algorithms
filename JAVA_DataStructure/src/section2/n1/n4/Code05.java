package section2.n1.n4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {

	// 사각형을 저장할 객체 배열
	static MyRectangle1[] rects;
	// 사각형 갯수
	static int n = 0;

	public static void main(String[] args) {
		rects = new MyRectangle1[10];
		// 데이터 파일 읽기
		try {
			Scanner in = new Scanner(new File("data.txt"));
			while (in.hasNext()) {
				// 객체 생성
				rects[n] = new MyRectangle1();
				rects[n].lu = new MyPoint1();
				
				// 파일의 정수 읽기
				rects[n].lu.x = in.nextInt();
				rects[n].lu.y = in.nextInt();
				rects[n].width = in.nextInt();
				rects[n].height = in.nextInt();
				n++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No Data File");
			System.exit(1);
		}
		bubbleSort();
		
		for(int i = 0; i < n; i++) {
			System.out.println(
					rects[i].lu.x + " " + rects[i].lu.y + " " +
					rects[i].width + " " + rects[i].height);
		}
	}

	private static void bubbleSort() {
		for(int i = n-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(calcArea(rects[j]) > calcArea(rects[j+1])) {
					MyRectangle1 tmp = rects[j];
					rects[j] = rects[j+1];
					rects[j+1] = tmp;
				}
			}
		}
	}
	
	public static int calcArea(MyRectangle1 r) {
		return r.width * r.height;
	}
}
