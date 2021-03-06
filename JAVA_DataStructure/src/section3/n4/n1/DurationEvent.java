package section3.n4.n1;

public class DurationEvent extends Event{
	public MyDate begin;
	public MyDate end;
	
	
	public DurationEvent(String title, MyDate begin, MyDate end) {
		super(title);
		this.begin = begin;
		this.end = end;
	}
	
	public boolean isRelevant(MyDate date) {
		return (begin.compareTo(date) <= 0 && end.compareTo(date) >= 0);
	}
	
	@Override
	public MyDate getRepresentativeDate() {
		return begin;
	}

	public String toString() {
		return "DurationEvent [title= " + title + ", begin= " + begin.toString() + ", end= " + end.toString() + "]";
	}
	
}
