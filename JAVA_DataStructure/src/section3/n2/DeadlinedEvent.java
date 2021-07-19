package section3.n2;

public class DeadlinedEvent extends Event{
	public MyDate deadline;
	
	public DeadlinedEvent(String title, MyDate deadline) {
		super(title);
		this.title = title;
		this.deadline = deadline;
	}

	public String toString() {
		return "DeadlinedEvent [title= " + title + ", deadline= " + deadline.toString() + "]";
	}
	
}
