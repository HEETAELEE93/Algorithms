package sort;

import java.util.Arrays;
import java.util.Comparator;

class Fruit {
	public String name;
	public int quantity;

	public Fruit(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

//	implements Comaparable	
//	@Override
//	public int compareTo(Fruit o) {
//		return o.quantity - quantity;
//	}
	
	public static Comparator<Fruit> nameComparator = new Comparator<Fruit>() {
		@Override
		public int compare(Fruit o1, Fruit o2) {
			return o1.name.compareTo(o2.name);
		}
	};
	
	public static Comparator<Fruit> quantComparator = new Comparator<Fruit>() {
		@Override
		public int compare(Fruit o1, Fruit o2) {
			return o1.quantity - o2.quantity;
		}
	};
}

public class HowToUseComparator {
	public static void main(String[] args) {
		Fruit[] f = new Fruit[4];
		f[0] = new Fruit("Pineapple", 70);
		f[1] = new Fruit("Apple", 100);
		f[2] = new Fruit("Orange", 80);
		f[3] = new Fruit("Banana", 90);
//		Arrays.sort(f);
		
		Arrays.sort(f, Fruit.quantComparator);
		for(Fruit i : f) {
			System.out.println(i.name + " " + i.quantity);
		}
		
	}
}
