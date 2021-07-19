package section3.n4.n1;

public class DeadlinedEvent extends Event{
	public MyDate deadline;
	
	public DeadlinedEvent(String title, MyDate deadline) {
		super(title);
		this.title = title;
		this.deadline = deadline;
	}
	
	public boolean isRelevant(MyDate date) {
		return (deadline.compareTo(date) >= 0);
	}

	@Override
	public MyDate getRepresentativeDate() {
		return deadline;
	}

	public String toString() {
		return "DeadlinedEvent [title= " + title + ", deadline= " + deadline.toString() + "]";
	}
	
}
