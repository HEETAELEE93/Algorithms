package section3.n4.n1;

public class OneDayEvent extends Event{
	public MyDate date;
	
	public OneDayEvent(String title, MyDate date) {
		super(title);
		this.date = date;
	}
	
	public boolean isRelevant(MyDate date) {
		return (this.date.compareTo(date) == 0);
	}
	
	@Override
	public MyDate getRepresentativeDate() {
		return date;
	}

	public String toString() {
		return "OneDayEvent [title= " + title + ", date= " + date.toString() + "]";
	}

}
