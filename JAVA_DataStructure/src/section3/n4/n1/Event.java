package section3.n4.n1;

public abstract class Event implements Comparable{
	public String title;

	public Event(String title) {
		this.title = title;
	}
	
	public abstract boolean isRelevant(MyDate date);
	
	public abstract MyDate getRepresentativeDate();

	@Override
	public int compareTo(Object o) {
		MyDate mine = getRepresentativeDate();
		MyDate yours = ((Event)o).getRepresentativeDate();
		
		return mine.compareTo(yours);
	}
	
}
