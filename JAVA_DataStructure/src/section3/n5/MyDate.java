package section3.n5;

public class MyDate {
	public int year;
	public int month;
	public int day;

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// 추상클래스, 인터페이스1 20m
	public int compareTo(MyDate other) {
		if(this.year < other.year 
				|| this.year == other.year 
				&& this.month < other.month 
				|| this.year == other.year 
				&& this.month == other.month 
				&& this.day < other.day) {
			return -1;
		}
		else if(this.year > other.year 
				|| this.year == other.year 
				&& this.month > other.month 
				|| this.year == other.year 
				&& this.month == other.month 
				&& this.day > other.day) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public String toString() {
		return year + "/" + month + "/" + day;
	}
	
}
