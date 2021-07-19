package section3.n4.n2;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication {
	private int capacity = 10;
	private Shape[] shapes = new Shape[capacity];
	private int n = 0;
	
	private Scanner sc = new Scanner(System.in);
	
	public void processCommand() {
		while(true) {
			System.out.print("$ ");
			String command = sc.next();
			if(command.equals("add")) {
				handleAdd();
			} else if(command.equals("show") || command.equals("showdetail")) {
				handleShow(command.equals("showdetail"));
			} else if(command.equals("sort")) {
				Arrays.sort(shapes, 0, n);
			} else if(command.equals("exit")) {
				break;
			}
		}
		sc.close();
	}
	
	private void handleAdd() {
		String type = sc.next();
		switch(type) {
		case "R":
			int w = sc.nextInt();
			int h = sc.nextInt();
			Rectangle r = new Rectangle(w, h);
			addShape(r);
			break;
		case "C":
			addShape(new Circle(sc.nextInt()));
			break;
		case "T":
			break;
		}
	}

	private void addShape(Shape shape) {
		shapes[n++] = shape;
	}

	private void handleShow(boolean detailed) {
		for(int i = 0; i < n; i++) {
			System.out.println((i+1) + ". " + shapes[i].toString());
			if(detailed) {
				System.out.println("   The Area is " + shapes[i].computeArea());
				System.out.println("   The Perimeter is " + shapes[i].computePerimeter());
			}
		}
	}

//	private void bubbleSort() {
//		for(int i = n-1; i > 0; i--) {
//			for(int j = 0; j < i; j++) {
//				if(shapes[j].computeArea() > shapes[j+1].computeArea()) {
//					Shape tmp = shapes[j];
//					shapes[j] = shapes[j+1];
//					shapes[j+1] = tmp;
//				}
//			}
//		}
//	}
	
	private void bubbleSort(MyComparable[] data, int size) {
		for(int i = size-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(data[j].compareTo(data[j+1]) > 0) {
					MyComparable tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		ShapeApplication app = new ShapeApplication();
		app.processCommand();
	}
}
