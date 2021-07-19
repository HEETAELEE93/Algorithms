package section3.n4.n1;

import java.util.Arrays;
import java.util.Scanner;

public class Scheduler {
	private int capacity = 10;
//	OneDayEvent[] onedays = new OneDayEvent[100];
//	DurationEvent[] durations = new DurationEvent[100];
//	DeadlinedEvent[] deadlines = new DeadlinedEvent[100];
	Event[] events = new Event[capacity];

	// 각각의 배열에 저장되어 있는 데이터의 갯수
	// int n1 = 0, n2 = 0, n3 = 0;
	int n = 0;

	private Scanner kb;

	public void processCommand() {
		kb = new Scanner(System.in);
		while (true) {
			System.out.print("$ ");
			String command = kb.next();

			if (command.equals("addevent")) {
				String type = kb.next();
				if (type.equalsIgnoreCase("oneday")) {
					handleAddOneDayEvent();
				} else if (type.equalsIgnoreCase("duration")) {
					handleAddDurationEvent();
				} else if (type.equalsIgnoreCase("deadline")) {
					handleAddDeadlinedEvent();
				}
			} else if (command.equals("list")) {
				handleList();
			} else if (command.equals("show")) {
				handleShow();
			} else if (command.equals("sort")) {
				Arrays.sort(events, 0, n);
			} else if (command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}

	private void handleShow() {
		String dateString = kb.next();
		MyDate theDate = parseDateString(dateString);
		for(int i = 0; i < n; i++) {
			if(events[i].isRelevant(theDate)) {
				System.out.println(events[i].toString());
			}
		}
	}

	private void handleList() {
		for (int i = 0; i < n; i++) {
			System.out.println("  " + events[i].toString());
		}
	}

	private void handleAddDeadlinedEvent() {
		System.out.println("until: ");
		String until = kb.next();

		System.out.print("title: ");
		String title = kb.next();

		MyDate date = parseDateString(until);

		DeadlinedEvent deadEv = new DeadlinedEvent(title, date);
		addEvent(deadEv);
	}

	private void handleAddDurationEvent() {
		System.out.print("begin: ");
		String begin = kb.next();

		System.out.print("end: ");
		String end = kb.next();

		System.out.print("title: ");
		String title = kb.next();

		MyDate date1 = parseDateString(begin);
		MyDate date2 = parseDateString(end);

		DurationEvent duEv = new DurationEvent(title, date1, date2);
		addEvent(duEv);
	}

	private void handleAddOneDayEvent() {
		System.out.print("when: ");
		String dateString = kb.next(); // dateString = "2020/03/18"

		System.out.print("title: ");
		String title = kb.next();

		MyDate date = parseDateString(dateString);

		OneDayEvent ev = new OneDayEvent(title, date);
		addEvent(ev);
	}

	private MyDate parseDateString(String dateString) { // dateString = "2020/03/18"
		String[] tokens = dateString.split("/");

		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);

		MyDate d = new MyDate(year, month, day);

		return d;
	}

	private void addEvent(Event ev) {
		if (n >= capacity) {
			reallocate();
		}
		events[n++] = ev;
	}


	// 배열 재할당
	private void reallocate() {
		Event[] tmp = new Event[capacity * 2];
		for (int i = 0; i < n; i++) {
			tmp[i] = events[i];
		}
		events = tmp;
		capacity *= 2;
	}

	public static void main(String[] args) {

		Scheduler app = new Scheduler();
		app.processCommand();
	}
}